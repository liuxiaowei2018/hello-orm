package com.open.orm.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.open.orm.mybatisplus.dataobject.User;
import com.open.orm.mybatisplus.mapper.UserMapper;
import com.open.orm.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaowei
 * @date 2022年11月09日 13:04
 * @Description
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
