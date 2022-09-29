package com.open.orm.mybatis.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.open.orm.mybatis.dataobject.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuxiaowei
 * @date 2022年09月29日 16:17
 * @Description mapper继承MPJBaseMapper (必选)
 * service继承MPJBaseService (可选)
 * serviceImpl继承MPJBaseServiceImpl (可选)
 */
@Mapper
public interface StudentMapper extends MPJBaseMapper<Student> {

}
