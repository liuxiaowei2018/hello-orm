package com.open.orm.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.open.orm.HelloOrmApplication;
import com.open.orm.mybatisplus.dataobject.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.util.List;
import java.util.Random;

/**
 * @author liuxiaowei
 * @date 2022年09月26日 13:37
 * @Description 多线程批量操作测试
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class DataSourceTransactionManagerTest {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateUser() {
        // 自动事务提交 2s143ms
        List<UserDO> all = userMapper.selectList(new LambdaQueryWrapper<UserDO>().last("limit 1000000"));
        all.forEach(s -> {
            String newUser = "Test_" + new Random().nextInt(100);
            s.setUsername(newUser);
            userMapper.updateById(s);
        });
    }

    @Test
    public void updateUserByTransaction() {
        // 手动事务提交 866ms [有效提高操作效率]
        List<UserDO> all = userMapper.selectList(new LambdaQueryWrapper<UserDO>().last("limit 1000000"));
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            all.forEach(s -> {
                String newUser = "Test_" + new Random().nextInt(100);
                s.setUsername(newUser);
                userMapper.updateById(s);
            });
            dataSourceTransactionManager.commit(transaction);
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transaction);
            throw e;
        }
    }
}
