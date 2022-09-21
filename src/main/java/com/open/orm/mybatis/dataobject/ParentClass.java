package com.open.orm.mybatis.dataobject;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 16:24
 * @Description
 */
public class ParentClass {
    public static String name = "爸爸";
    public int age = 40;

    public ParentClass(){
        System.out.println("父类构造函数");
    }

    // 非静态代码块
    {
        System.out.println("父类非静态代码块" + "---" + age);
    }

    // 静态代码块
    static{
        System.out.println("父类静态代码块" + "---" + name);
    }

}


