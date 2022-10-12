package com.open.orm.jpa.repository;

import com.open.orm.jpa.pojo.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:56
 * @Description
 */
public interface UserRepository01 extends CrudRepository<UserDO, Integer> {
}
