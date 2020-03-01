package org.gupao.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/1 15:52
 */
public class Test {
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.setName("Jhon");
        boy.setAge(12);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("学习");
        boy.setHobbies(hobbies);

        System.out.println("boy" + boy);

        Boy boy1 = boy.clone();
        boy1.getHobbies().add("看书");
        boy1.getHobbies().add("上网");
        System.out.println("boy1" + boy1);

        Boy boy2 = boy.SerializableClone();
        boy2.getHobbies().add("打网球");
        boy2.getHobbies().add("跑步");

        System.out.println("boy2" + boy2);
    }
}
