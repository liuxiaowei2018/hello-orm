package com.open.orm.mybatis.dataobject;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 16:25
 * @Description
 */
public class ChildrenClass extends ParentClass{
    public static String name = "儿子";
    public int age = 15;

    public ChildrenClass(){
        System.out.println("子类构造函数");
    }

    {
        System.out.println("子类非静态代码块" + "---" + age);
    }

    static {
        System.out.println("子类静态代码块" + "---" + name);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        b = (a+b) - (a=b);
        System.out.println(a);
        System.out.println(b);
    }
}
