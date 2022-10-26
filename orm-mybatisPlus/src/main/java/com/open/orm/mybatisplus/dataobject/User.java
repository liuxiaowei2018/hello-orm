package com.open.orm.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liuxiaowei
 * @date 2022年10月26日 18:01
 * @Description
 */
@Data
@TableName(value = "t_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名（不能重复）
     */

    private String userName;

    /**
     * 昵称（可以重复）
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 0：未删除 其他：已删除
     * UNIQUE KEY `index_user_name_deleted_flag` (`user_name`, `deleted_flag`)
     */
    @TableLogic(delval = "id")
    private Long deletedFlag;
}
