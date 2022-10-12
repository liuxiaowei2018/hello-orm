package com.open.orm.jpa.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuxiaowei
 * @date 2022年10月12日 17:55
 * @Description
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class UserDO implements Serializable {

    /**
     * 用户编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  // strategy 设置使用数据库主键自增策略；
            generator = "JDBC") // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer id;

    /**
     * 账号
     */
    @Column(nullable = false)
    private String username;

    /**
     * 密码（明文）
     */
    @Column(nullable = false)
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;
}
