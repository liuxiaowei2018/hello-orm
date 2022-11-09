package com.open.orm.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:32
 * @Description
 */
@Data
@Accessors(chain = true)
@TableName(value = "users")
public class UserDO {

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
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;

    /**
     * 原生Jdbc 测试
     *
     * @param args
     * @date 2022/10/12 17:36
     */
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select count(0) as total from users where username=?";
            //1,注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2,获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
            //3,获取语句会话对象,这里我们获取的是预编译处理会话，可以防止SQL注入
            ps = conn.prepareStatement(sql);
            //给占位符? 赋值，setObject() 第一个参数为占位符位置，第二个参数为实际传入的值
            ps.setObject(1, "liuxiaowei");
            //执行语句得到返回值
            rs = ps.executeQuery();
            int total = 0;
            if (rs.next()) {
                total = rs.getInt("total");
            }
            System.out.println(total);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
