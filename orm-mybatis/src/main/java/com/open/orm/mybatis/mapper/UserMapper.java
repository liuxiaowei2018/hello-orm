package com.open.orm.mybatis.mapper;

import com.open.orm.mybatis.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:34
 * @Description
 * 说明1: @Repository 注解，用于标记是数据访问 Bean 对象。在 MyBatis 的接口，实际非必须，只是为了避免在 Service 中，@Autowired 注入时无需报警。
 * 说明2: @Param 注解，声明变量名。
 *      在方法为单参数时，非必须。
 *      在方法为多参数时，必须。[禁止使用 Map 作为查询参数]
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户结果集
     *
     * @param username 用户名
     * @return 查询结果
     */
    @Select("SELECT * FROM users WHERE username = #{username}")
    List<UserDO> findByUsername(@Param("username") String username);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(UserDO user);

    int updateById(UserDO user);

    int deleteById(@Param("id") Integer id);

    UserDO selectById(@Param("id") Integer id);

    UserDO selectByUsername(@Param("username") String username);

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);

}
