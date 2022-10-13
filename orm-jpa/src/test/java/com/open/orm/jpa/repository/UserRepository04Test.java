package com.open.orm.jpa.repository;

import com.open.orm.HelloOrmApplication;
import com.open.orm.jpa.pojo.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:57
 * @Description 基于方法名查询测试
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class UserRepository04Test {

    @Autowired
    private UserRepository04 repository04;

    @Test
    public void testFindIdByUsername01() {
        UserDO user = repository04.findByUsername01("xxx");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername02() {
        UserDO user = repository04.findByUsername02("xxx");
        System.out.println(user);
    }

    @Test
    public void testFindIdByUsername03() {
        UserDO user = repository04.findByUsername03("xxx");
        System.out.println(user);
    }

    @Test
    // 更新操作，需要在事务中。
    // 在单元测试中，事务默认回滚
    @Transactional
    public void testUpdateUsernameById() {
        repository04.updateUsernameById(5, "xxxxxx");
    }


}