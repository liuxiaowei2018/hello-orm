package com.open.orm.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.orm.mybatisplus.dataobject.Blog;
import com.open.orm.mybatisplus.dto.BlogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author liuxiaowei
 * @date 2022年09月29日 16:17
 * @Description
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 静态查询
     */
    @Select("SELECT t_user.user_name " +
            " FROM t_blog, t_user " +
            " WHERE t_blog.id = #{id} " +
            "     AND t_blog.user_id = t_user.id")
    String findUserNameByBlogId(@Param("id") Long id);

    /**
     * 动态查询
     */
    @Select("SELECT * " +
            " FROM t_blog, t_user " +
            " ${ew.customSqlSegment} ")
    IPage<BlogDTO> findBlog(IPage<BlogDTO> page, @Param("ew") Wrapper wrapper);
}
