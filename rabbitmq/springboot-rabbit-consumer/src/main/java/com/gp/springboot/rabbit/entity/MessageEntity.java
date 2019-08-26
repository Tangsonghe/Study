package com.gp.springboot.rabbit.entity;

import java.io.Serializable;

/**
 * @Author: Tangsonghe
 * @Description:
 * @Date: 15:01 2019/8/26
 */
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 2664501235645216794L;
    private String id;
    private String message;
    private String type;

    public String getId() {
        return id;
    }

    public MessageEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getType() {
        return type;
    }

    public MessageEntity setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
