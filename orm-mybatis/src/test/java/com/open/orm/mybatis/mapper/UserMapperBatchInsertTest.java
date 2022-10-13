package com.open.orm.mybatis.mapper;

import com.open.orm.HelloOrmApplication;
import com.open.orm.mybatis.dataobject.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:35
 * @Description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class UserMapperBatchInsertTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 正常forEach插入
     * sql : INSERT INTO `table1` (`field1`, `field2`)
     *       VALUES ("data1", "data2"),
     *      ("data1", "data2"),
     *      ("data1", "data2"),
     *      ("data1", "data2"),
     *      ("data1", "data2");
     * 当表的列数较多（20+），以及一次性插入的行数较多（5000+）时，整个插入的耗时十分漫长
     */
    @Test
    public void testBatchInsert() {
        ArrayList<UserDO> userDOS = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                    .setPassword("xxx").setCreateTime(new Date());
            userDOS.add(user);
        }
        userMapper.batchInsert(userDOS);
    }

    /**
     * MyBatis session 的 executor type 设为 Batch ，然后多次执行插入语句
     */
    @Test
    @Transactional
    public void testBatchInsertV1() {
        ArrayList<UserDO> userDOS = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                    .setPassword("xxx").setCreateTime(new Date());
            userDOS.add(user);
        }
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            for (UserDO userDO : userDOS) {
                mapper.insert(userDO);
            }
            session.commit();
            session.clearCache();
        } finally {
            session.close();
        }

    }

}