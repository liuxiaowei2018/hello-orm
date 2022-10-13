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
public class UserRepository03Test {

    @Autowired
    private UserRepository03 repository03;

    @Test
    public void testFindByUsername() {
        UserDO user = repository03.findByUsername("xxx");
        System.out.println(user);
    }

    @Test
    public void testFindByCreateTimeAfter() {
        // 创建分页条件
        Pageable pageable = PageRequest.of(1, 10);
        // 执行分页操作
        // 临时 Demo ，实际不建议这么写
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24);
        Page<UserDO> page = repository03.findByCreateTimeAfter(createTime, pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

}