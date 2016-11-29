package com.picsart.data.druidinception;

public class Data {
    private String key;
    private Double value;

    public Data(){

    }
    public Data(String key, Double value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Double getValue() {
        return value;
    }
}