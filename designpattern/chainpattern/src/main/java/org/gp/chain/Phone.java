package org.gp.chain;

import lombok.Data;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/15 15:44
 */
@Data
public class Phone {

    private String screen;

    private String button;

    private String camera;

    private String cpu;

    private String battery;

    private String hardware;

    private String open;

    @Override
    public String toString() {
        return "{" +
                "screen='" + screen + '\'' +
                ", button='" + button + '\'' +
                ", camera='" + camera + '\'' +
                ", cpu='" + cpu + '\'' +
                ", battery='" + battery + '\'' +
                ", hardware='" + hardware + '\'' +
                ", open='" + open + '\'' +
                '}';
    }
}
