package com.open.orm.mybatisplus.mapper;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.orm.HelloOrmApplication;
import com.open.orm.mybatisplus.dto.BlogDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * @author liuxiaowei
 * @date 2022年10月26日 17:51
 * @Description mybatisPlus连表查询
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class BlogMapperTest {


    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void staticQuery() {
        String data =  blogMapper.findUserNameByBlogId(1L);
        log.info(data);
    }

    @Test
    public void dynamicQuery() {
        Page<BlogDTO> page = new Page<>();
        String nickName = "刀";
        String title = "";
        QueryWrapper<BlogDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(nickName), "t_user.nick_name", nickName);
        queryWrapper.like(StringUtils.hasText(title), "t_blog.title", title);
        queryWrapper.eq("t_blog.deleted_flag", 0);
        queryWrapper.eq("t_user.deleted_flag", 0);
        queryWrapper.apply("t_blog.user_id = t_user.id");
        IPage<BlogDTO> blog = blogMapper.findBlog(page, queryWrapper);
        log.info(JSONUtil.toJsonStr(blog));
    }
}