package org.gp.cmd;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:19
 */
public class FtpServer {

    public void open() {
        System.out.println("ftp服务打开");
    }

    public void cd(String path) {
        System.out.println("进入目录: " + path);
    }

    public void ls(String path) {
        if (path != null) {
            System.out.println(path + "目录下的列表");
        }
        System.out.println("当前目录列表");
    }

    public void mkdir(String name) {
        System.out.println("创建目录成功!");
    }

}
