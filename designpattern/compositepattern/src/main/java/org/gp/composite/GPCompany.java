package org.gp.composite;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/8 12:33
 */
public abstract class GPCompany {

    protected String name;

    public GPCompany(String name) {
        this.name = name;
    }

    public abstract void show();
}
