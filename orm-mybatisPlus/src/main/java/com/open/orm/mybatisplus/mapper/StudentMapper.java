package com.open.orm.mybatisplus.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.open.orm.mybatisplus.dataobject.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuxiaowei
 * @date 2022年09月29日 16:17
 * @Description
 * 说明1: mapper继承MPJBaseMapper(必选)
 * 说明2: service继承MPJBaseService(可选)
 * 说明3: serviceImpl继承MPJBaseServiceImpl(可选)
 */
@Mapper
public interface StudentMapper extends MPJBaseMapper<Student> {

}
