package com.open.orm.mybatisplus.mapper;

import com.open.orm.HelloOrmApplication;
import com.open.orm.mybatisplus.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author liuxiaowei
 * @date 2022年09月29日 20:31
 * @Description MPJLambdaWrapper 其他功能
 * 简单的SQL函数使用：https://gitee.com/best_handsome/mybatis-plus-join/wikis/selectFunc()?sort_id=4082479
 * ON语句多条件支持：https://gitee.com/best_handsome/mybatis-plus-join/wikis/leftJoin?sort_id=3496671
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloOrmApplication.class)
public class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testJoinList() {
//        studentMapper.selectJoinList(Student.class,
//                new MPJLambdaWrapper<Student>()
//                        .selectAll(Student.class)
//                        .select(UserAddressDO::getTel)
//                        .selectAs(UserAddressDO::getAddress, UserDTO::getUserAddress)
//                        .select(AreaDO::getProvince, AreaDO::getCity)
//                        .leftJoin(UserAddressDO.class, UserAddressDO::getUserId, UserDO::getId)
//                        .leftJoin(AreaDO.class, AreaDO::getId, UserAddressDO::getAreaId)
//                        .eq(UserDO::getId, 1)
//                        .like(UserAddressDO::getTel, "1")
//                        .gt(UserDO::getId, 5));

        // SELECT
        //    t.id,
        //    t.name,
        //    t.sex,
        //    t.head_img,
        //    t1.tel,
        //    t1.address AS userAddress,
        //    t2.province,
        //    t2.city
        // FROM
        //    user t
        //    LEFT JOIN user_address t1 ON t1.user_id = t.id
        //    LEFT JOIN area t2 ON t2.id = t1.area_id
        // WHERE (
        //    t.id = ?
        //    AND t1.tel LIKE ?
        //    AND t.id > ?)

        //UserDTO.class 查询结果返回类(resultType)
        //selectAll() 查询指定实体类的全部字段
        //select() 查询指定的字段,支持可变参数,同一个select只能查询相同表的字段 故将UserAddressDO和AreaDO分开为两个select()
        //selectAs() 字段别名查询,用于数据库字段与业务实体类属性名不一致时使用
        //leftJoin() 参数说明 第一个参数: 参与连表的实体类class 第二个参数: 连表的ON字段,这个属性必须是第一个参数实体类的属性 第三个参数: 参与连表的ON的另一个实体类属性
        //默认主表别名是t,其他的表别名以先后调用的顺序使用t1,t2,t3....
        //条件查询,可以查询主表以及参与连接的所有表的字段,全部调用mp原生的方法,正常使用没有sql注入风险
    }

    @Test
    public void testJoinPage() {
//        IPage<UserDTO> iPage = studentMapper.selectJoinPage(new Page<>(2, 10), Student.class,
//                new MPJLambdaWrapper<Student>()
//                        .selectAll(Student.class)
//                        .select(UserAddressDO::getTel)
//                        .selectAs(UserAddressDO::getAddress, UserDTO::getUserAddress)
//                        .select(AreaDO::getProvince, AreaDO::getCity)
//                        .leftJoin(UserAddressDO.class, UserAddressDO::getUserId, UserDO::getId)
//                        .leftJoin(AreaDO.class, AreaDO::getId, UserAddressDO::getAreaId));

        // SELECT
        //    t.id,
        //    t.name,
        //    t.sex,
        //    t.head_img,
        //    t1.tel,
        //    t1.address AS userAddress,
        //    t2.province,
        //    t2.city
        // FROM
        //    user t
        //    LEFT JOIN user_address t1 ON t1.user_id = t.id
        //    LEFT JOIN area t2 ON t2.id = t1.area_id
        // LIMIT ?,?
    }

    @Test
    public void testJoinThree() {
//        List<UserDTO> list = userMapper.selectJoinList(UserDTO.class,
//                new MPJQueryWrapper<UserDO>()
//                        .selectAll(UserDO.class)
//                        .select("addr.tel", "addr.address", "a.province")
//                        .leftJoin("user_address addr on t.id = addr.user_id")
//                        .rightJoin("area a on addr.area_id = a.id")
//                        .like("addr.tel", "1")
//                        .le("a.province", "1"));

        // SELECT
        //    t.id,
        //    t.name,
        //    t.sex,
        //    t.head_img,
        //    addr.tel,
        //    addr.address,
        //    a.province
        // FROM
        //    user t
        //    LEFT JOIN user_address addr on t.id = addr.user_id
        //    RIGHT JOIN area a on addr.area_id = a.id
        // WHERE (
        //    addr.tel LIKE ?
        //    AND a.province <= ?)

        //UserDTO.class 查询结果类(resultType)
        //selectAll(UserDO.class) 查询主表全部字段(主表实体类)默认主表别名 "t"
        //select() mp的select策略是覆盖,以最后一次为准,这里的策略是追加,可以一直select 主表字段可以用lambda,会自动添加表别名,主表别名默认是 t ,非主表字段必须带别名查询
        //leftJoin() rightJoin() innerJoin() 传sql片段 格式 (表 + 别名 + 关联条件)
        //条件查询,可以查询主表以及参与连接的所有表的字段,全部调用mp原生的方法,正常使用没有sql注入风险
    }

    @Test
    public void testJoinOther() {
//        List<UserDTO> list = userMapper.selectJoinList(UserDTO.class,
//                new MPJQueryWrapper<UserDO>()
//                        .selectAll(UserDO.class)
//                        .select("addr.tel", "addr.address")
//                        //行列转换
//                        .select("CASE t.sex WHEN '男' THEN '1' ELSE '0' END AS sex")
//                        //求和函数
//                        .select("sum(a.province) AS province")
//                        //自定义数据集
//                        .leftJoin("(select * from user_address) addr on t.id = addr.user_id")
//                        .rightJoin("area a on addr.area_id = a.id")
//                        .like("addr.tel", "1")
//                        .le("a.province", "1")
//                        .orderByDesc("addr.id"));

        // SELECT
        //    t.id,
        //    t.name,
        //    t.sex,
        //    t.head_img,
        //    addr.tel,
        //    addr.address,
        //    CASE t.sex WHEN '男' THEN '1' ELSE '0' END AS sex,
        //    sum(a.province) AS province
        // FROM
        //    user t
        //    LEFT JOIN (select * from user_address) addr on t.id = addr.user_id
        //    RIGHT JOIN area a on addr.area_id = a.id
        // WHERE (
        //    addr.tel LIKE ?
        //    AND a.province <= ?)
        // ORDER BY
        //    addr.id DESC
    }

}