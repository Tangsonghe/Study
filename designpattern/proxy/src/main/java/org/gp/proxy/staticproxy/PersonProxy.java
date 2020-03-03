package org.gp.proxy.staticproxy;

/**
 * @description: 静态代理
 * @author: Spark_tang
 * @time: 2020/3/2 21:55
 *
 * 静态代理属于硬编码，比较局限性，因为代理的对象已经明确，只能代理定义的对象。扩展性差。
 *
 */
public class PersonProxy implements IPerson {
    private Boy boy;

    public PersonProxy(Boy boy) {
        this.boy = boy;
    }

    public void findFirend() {
        System.out.println("开始找朋友");
        this.boy.findFirend();
        System.out.println("找到朋友，找朋友结束");
    }
}
