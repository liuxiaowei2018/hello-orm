package com.open.orm.mybatis.dataobject;

import lombok.Data;

import java.io.*;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 16:21
 * @Description
 */
@Data
public class Person implements Serializable {

    private transient int age;
    private String name;
    private String sex;

// 省略 get set

    public static void main(String[] args) throws Exception {
        serializePerson();
        Person p = deserializePerson();
        System.out.println(p.getName()+";"+p.getAge());
    }

    private static void serializePerson() throws FileNotFoundException, IOException {
        Person person = new Person();
        person.setName("测试实例");
        person.setAge(25);
        person.setSex("male");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("./data.txt")));
        oo.writeObject(person);
        oo.close();
    }

    private static Person deserializePerson() throws IOException, Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("./data.txt")));
        Person person = (Person) ois.readObject();
        return person;
    }
}
