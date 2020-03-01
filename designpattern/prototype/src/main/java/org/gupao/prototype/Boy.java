package org.gupao.prototype;

import com.google.gson.Gson;
import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * @description: 用json方式实现深度克隆
 * @author: Spark_tang
 * @time: 2020/3/1 15:43
 */
@Data
public class Boy implements IPrototype<Boy>, Serializable {

    private static final long serialVersionUID = -7597986229550378235L;

    private String name;

    private Integer age;

    List<String> hobbies;

    /**
     * java 自带克隆   要实现Cloneable的接口
     * @return
     */
    public Boy javaClone() {

        try {
            return (Boy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 序列化克隆
     * @return
     */
    public Boy SerializableClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(this);
            oos.flush();

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            Object o = ois.readObject();

            return (Boy) o;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    /**
     * json 克隆
     * @return
     */
    @Override
    public Boy clone() {
        Gson gson = new Gson();
        String boyStr = gson.toJson(this);
        return gson.fromJson(boyStr, Boy.class);
    }

    @Override
    public String toString() {
        return super.toString() + ", Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
