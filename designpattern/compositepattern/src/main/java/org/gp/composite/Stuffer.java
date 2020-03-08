package org.gp.composite;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/8 12:52
 */
public class Stuffer extends GPCompany {

    private String position;

    public Stuffer(String name, String position) {
        super(name);
        this.position = position;
    }

    @Override
    public void show() {
        System.out.println(this.position + ": " + this.name);
    }
}
