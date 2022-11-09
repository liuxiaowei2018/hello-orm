package com.open.orm.mybatisplus.service;

import com.open.orm.HelloOrmApplication;
import com.open.orm.mybatisplus.dataobject.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxiaowei
 * @date 2022年11月09日 13:07
 * @Description 测试 mybatisPlus设置字段为null
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = new User().setId(1L);
        // UPDATE t_user SET nick_name=? WHERE deleted_flag=0 AND (id = ?)
        userService.lambdaUpdate()
                .eq(User::getId, user.getId())
                .set(User::getNickName, null).update();
    }

}