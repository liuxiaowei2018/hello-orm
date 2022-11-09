package com.open.orm.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.open.orm.mybatisplus.dataobject.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:34
 * @Description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
