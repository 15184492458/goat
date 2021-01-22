package com.goat.api.core.config;

import java.io.Serializable;

public class ServiceConfig implements Serializable{

    private static final long serialVersionUID = 5248778656962620314L;

    private String host;

    private String port;

    private String id;

    private String name;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
