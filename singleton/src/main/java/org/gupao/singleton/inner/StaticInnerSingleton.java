package org.gupao.singleton.inner;

/**
 * @Author: Spark_tang
 * @Description: 静态内部类单例
 * @Date: Created in 15:53 2020/2/27
 *
 *
 * java加载class文件的机制
 * 先去在classpath路径下加载主类 StaticInnerSingleton.class.
 * 然后在调用StaticInnerSingleton的getInstance方法时候再去加载内部类 StaticInnerSingleton$InnerClass
 *
 * 优点：节省内存空间，利用java自身的语法特点，性能高，避免内存浪费
 * 缺点：可以被反射机制破坏
 *
 * 防止放射，可以在私有构造函数中判断来解决
 * 但是会造成代码可读性差，混淆。
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {
        // 防反射
        if (InnerClass.SINGLETON != null) {
            throw new RuntimeException("此类不能通过反射构建");
        }
    }

    public static StaticInnerSingleton getInstance() {

        return InnerClass.SINGLETON;
    }

    private static class InnerClass {

        private static final StaticInnerSingleton SINGLETON = new StaticInnerSingleton();
    }

}
