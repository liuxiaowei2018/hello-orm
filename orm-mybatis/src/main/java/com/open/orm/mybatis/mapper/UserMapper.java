package com.open.orm.mybatis.mapper;

import com.open.orm.mybatis.dataobject.UserDO;
import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO users(username, password, create_time) VALUES(#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertUser(UserDO user);

    @Update(value = {
            "<script>",
            "UPDATE users",
            "<set>",
            "<if test='username != null'>, username = #{username}</if>",
            "<if test='password != null'>, password = #{password}</if>",
            "</set>",
            "</script>"
    })
    int updateByUserId(UserDO user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteByUserId(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM users WHERE id = #{id}")
    UserDO selectByIdV1(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM users WHERE username = #{username}")
    UserDO selectByUsernameV1(@Param("username") String username);

    @Select(value = {
            "<script>",
            "SELECT username, password, create_time FROM users",
            "WHERE id IN",
            "<foreach item='id' collection='ids' separator=',' open='(' close=')' index=''>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<UserDO> selectByIdsV1(@Param("ids") Collection<Integer> ids);

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
