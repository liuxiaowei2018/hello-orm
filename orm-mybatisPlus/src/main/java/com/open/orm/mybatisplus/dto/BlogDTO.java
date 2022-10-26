package com.open.orm.mybatisplus.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liuxiaowei
 * @date 2022年10月26日 17:44
 * @Description
 */
@Data
public class BlogDTO {

    private Long id;

    private Long userId;

    private String userName;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 昵称（这个是t_user的字段）
     */
    private String nickName;
}
