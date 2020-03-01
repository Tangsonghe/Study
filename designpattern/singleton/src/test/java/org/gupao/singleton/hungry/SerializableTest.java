package org.gupao.singleton.hungry;

import org.junit.Test;

import java.io.*;

/**
 * @description: 反序列化破坏单例测试
 * @author: Spark_tang
 * @time: 2020/3/1 12:18
 *
 * 控制台输出：
 * singleton1 === org.gupao.singleton.hungry.HungrySingleton@1698c449
 * singleton2 === org.gupao.singleton.hungry.HungrySingleton@1698c449
 * deserialization === org.gupao.singleton.hungry.HungrySingleton@7fbe847c
 *
 * 可以看出 发序列化破坏了单例。
 * 从源码中发现，readObject方法里面 会进行检查反射类中是否有readResolve方法，
 * 我们只需在单列类中添加readResolve()方法即可。
 * class-defined readResolve method, or null if none
 * private Method readResolveMethod; （这是源码中的定义）
 *
 * 添加方法readResolve()方法后的测试。控制台打印：
 * singleton1 === org.gupao.singleton.hungry.HungrySingleton@5387f9e0
 * singleton2 === org.gupao.singleton.hungry.HungrySingleton@5387f9e0
 * deserialization === org.gupao.singleton.hungry.HungrySingleton@5387f9e0
 *
 * 问题解决。
 *
 */
public class SerializableTest {

    @Test
    public void serializableTest() {

        HungrySingleton singleton1 = HungrySingleton.getInstance();
        HungrySingleton singleton2 = HungrySingleton.getInstance();

        System.out.println("singleton1 === " + singleton1);
        System.out.println("singleton2 === " + singleton2);

        try {
            FileOutputStream fos = new FileOutputStream("object.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(singleton1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream(new File("object.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            System.out.println("deserialization === " + o);
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
