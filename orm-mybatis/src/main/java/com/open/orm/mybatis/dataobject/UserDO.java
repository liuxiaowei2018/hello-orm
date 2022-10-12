package com.open.orm.mybatis.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:32
 * @Description
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserDO implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码（明文）
     * <p>
     * ps：生产环境下，千万不要明文
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;

    public UserDO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
