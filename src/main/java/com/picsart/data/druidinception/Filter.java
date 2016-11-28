package com.picsart.data.druidinception;

import java.util.List;
/**
 * Created by hrachyeghishyan on 11/17/16.
 */
public class Filter {
    private String type;
    private List<Fields> fields;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Fields> getFileds() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }


}
