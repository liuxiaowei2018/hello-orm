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
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:57
 * @Description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class UserRepository02Test {

    @Autowired
    private UserRepository02 repository02;

    /**
     * 排序
     *
     * @date 2022/10/13 13:08
     */
    @Test
    public void testFindAll() {
        // 执行排序操作
        Iterable<UserDO> iterable = repository02.findAll(Sort.by(Sort.Direction.DESC, "id"));
        // 打印
        iterable.forEach(System.out::println);
    }

    /**
     * 分页
     *
     * @date 2022/10/13 13:08
     */
    @Test
    public void testFindPage() {
        // 创建排序分页条件
        Pageable pageable = PageRequest.of(1, 10, Sort.by(Sort.Direction.DESC, "id"));
        // 执行分页操作
        Page<UserDO> page = repository02.findAll(pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
    }

}