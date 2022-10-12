package com.open.orm.jpa.repository;

import com.open.orm.HelloOrmApplication;
import com.open.orm.jpa.pojo.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:57
 * @Description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class UserRepository01Test {

    @Autowired
    private UserRepository01 repository01;

    @Test // 插入一条记录
    public void testSave() {
        UserDO user = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("xxx").setCreateTime(new Date());
        repository01.save(user);
    }

    @Test // 更新一条记录
    public void testUpdate() {
        // 先查询一条记录
        Optional<UserDO> userDO = repository01.findById(1);
        Assert.isTrue(userDO.isPresent(), "记录不能为空");
        // 更新一条记录
        UserDO updateUser = userDO.get();
        updateUser.setPassword("xxxxxx");
        repository01.save(updateUser);
    }

    @Test // 根据 ID 编号，删除一条记录
    public void testDelete() {
        repository01.deleteById(2);
    }

    @Test // 根据 ID 编号，查询一条记录
    public void testSelectById() {
        Optional<UserDO> userDO = repository01.findById(1);
        System.out.println(userDO.get());
    }

    @Test // 根据 ID 编号数组，查询多条记录
    public void testSelectByIds() {
        Iterable<UserDO> users = repository01.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }

}