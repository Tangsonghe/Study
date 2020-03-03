package org.gp.proxy.dynamicproxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/2 21:46
 */
public class JdkTest {
    public static void main(String[] args) {
        WechatProxy proxy = new WechatProxy();
        IWechat wechat = proxy.getInstance(new Wechat());
        wechat.send("欢迎使用代理工厂");

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0.java", new Class[]{IWechat.class});
        try {
            OutputStream os = new FileOutputStream("D:/gp源码/$Proxy0.class");
            os.write(bytes);
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
