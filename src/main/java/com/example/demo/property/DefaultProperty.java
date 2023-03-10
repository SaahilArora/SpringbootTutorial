package com.example.demo.property;

public class DefaultProperty {
    String name;
    String code;
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DefaultProperty{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
