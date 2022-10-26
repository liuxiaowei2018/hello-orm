package com.open.orm.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liuxiaowei
 * @date 2022年10月26日 17:49
 * @Description
 */
@TableName("t_bolg")
@Data
public class Blog {

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

}
