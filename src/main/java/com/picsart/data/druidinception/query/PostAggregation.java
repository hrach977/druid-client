package com.picsart.data.druidinception.query;

/**
 * @author hrachya.yeghishyan@picsart.com
 */

public class PostAggregation {
    private String type;
    private String name;
    private String fn;
    private Fields[] fields;
    private String ordering;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public Fields[] getFields() {
        return fields;
    }

    public void setFields(Fields[] fields) {
        this.fields = fields;
    }

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
