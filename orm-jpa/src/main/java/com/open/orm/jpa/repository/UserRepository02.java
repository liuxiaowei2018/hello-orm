package com.open.orm.jpa.repository;

import com.open.orm.jpa.pojo.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:56
 * @Description 分页排序操作
 */
public interface UserRepository02 extends PagingAndSortingRepository<UserDO, Integer> {
}
