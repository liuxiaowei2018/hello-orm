package com.open.orm.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.orm.HelloOrmApplication;
import com.open.orm.mybatisplus.dataobject.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:35
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword("123456");
        user.setCreateTime(new Date());
        user.setDeleted(0); // 一般情况下，是否删除，可以全局枚举下。
        userMapper.insert(user);
    }

    @Test
    public void testInsertBatch() {
        for (int i = 0; i < 1000; i++) {
            UserDO user = new UserDO();
            user.setUsername(UUID.randomUUID().toString());
            user.setPassword("123456");
            user.setCreateTime(new Date());
            user.setDeleted(0); // 一般情况下，是否删除，可以全局枚举下。
            userMapper.insert(user);
        }
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO();
        updateUser.setId(1);
        updateUser.setPassword("xxx");
        userMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(2);
    }

    @Test
    public void testSelectById() {
        userMapper.selectById(1);
    }

    @Test
    public void testSelectByUsername() {
        userMapper.selectByUsername("xxx");
    }

    @Test
    public void testSelectPageByCreateTime() {
        IPage<UserDO> page = new Page<>(1, 10);
        // 临时 Demo ，实际不建议这么写
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24);
        page = userMapper.selectPageByCreateTime(page, createTime);
        System.out.println("users：" + page.getRecords().size());
    }

}