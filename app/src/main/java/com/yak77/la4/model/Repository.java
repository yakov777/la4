package com.yak77.la4.model;

public class Repository {
    private final long id;
    private final String name;
    private final String nametype;
    private final int mass;

    public Repository(long id, String name, String nametype, int mass) {
        this.id = id;
        this.name = name;
        this.nametype = nametype;
        this.mass = mass;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNametype() {
        return nametype;
    }

    public int getMass() {
        return mass;
    }
}
