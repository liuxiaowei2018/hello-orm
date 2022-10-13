package com.open.orm.jpa.repository;

import com.open.orm.jpa.pojo.UserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:56
 * @Description 基于注解查询
 */
public interface UserRepository04 extends PagingAndSortingRepository<UserDO, Integer> {

    // 使用 @Query 自定义了一个 SQL 操作，并且参数使用占位符(?) + 参数位置的形式
    @Query("SELECT u FROM UserDO u WHERE u.username = ?1")
    UserDO findByUsername01(String username);

    // 使用占位符(:) + **参数名字(需要使用 @Param 声明)**的形式
    @Query("SELECT u FROM UserDO u WHERE u.username = :username")
    UserDO findByUsername02(@Param("username") String username);

    // 增加了 nativeQuery = true ，表示在 @Query 自定义的是原生 SQL(表名)
    @Query(value = "SELECT * FROM users u WHERE u.username = :username", nativeQuery = true)
    UserDO findByUsername03(@Param("username") String username);

    // 定义了更新操作，需要加上 @Modifying 注解
    @Query("UPDATE UserDO  u SET u.username = :username WHERE u.id = :id")
    @Modifying
    int updateUsernameById(Integer id, String username);
}
