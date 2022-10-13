package com.open.orm.jpa.repository;

import com.open.orm.jpa.pojo.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:56
 * @Description 基于方法名查询
 */
public interface UserRepository03 extends PagingAndSortingRepository<UserDO, Integer> {

    UserDO findByUsername(String username);

    Page<UserDO> findByCreateTimeAfter(Date createTime, Pageable pageable);
}
