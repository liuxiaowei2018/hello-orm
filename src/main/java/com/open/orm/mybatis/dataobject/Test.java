package com.open.orm.mybatis.dataobject;

import java.io.UnsupportedEncodingException;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 16:20
 * @Description
 */
public class Test{
    public static void main(String[] args){
        // 初始化 A1
        Test test = new Test();
        Test.A1 a1 = test.new A1();
        a1.I++;
        // 初始化 A2
        //(2)
        Test.A2 a2=new Test.A2();
        a2.J++;
        // 初始化 A3
        //(3)
        Bean b=new Bean();
        Bean.A3 a3=b.new A3();
        a3.k++;
    }
    class A1{
        public int I = 0;
    }

    static class A2{
        public int J = 0;
    }
}

class Bean {
    class A3 {
        public int k = 0;
    }
}
