package com.open.orm.mybatis.dataobject;

import java.util.Scanner;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 16:28
 * @Description
 */
public class AAA {

    public int testExceptionReturn() {
        int i = 1;
        try {
            i++;
            int x = i / 0;
        } catch (Exception e) {
            i++;
            return i;
        } finally {
            i++;
        }
        return i;
    }

//    public static void main(String[] args) {
//        AAA exceptionTest = new AAA();
//        int testReturn3 = exceptionTest.testExceptionReturn();
//        System.out.println(testReturn3);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个浮点数：");
        while(sc.hasNext()){
            double num = sc.nextDouble();

            System.out.println("Math.floor(" + num + ") = " + Math.floor(num));
            System.out.println("Math.ceil(" + num + ") = " + Math.ceil(num));
            System.out.println("Math.rint(" + num + ") = " + Math.rint(num));
            System.out.println("Math.round(" + num + ") = " + Math.round(num));
        }
    }
}
