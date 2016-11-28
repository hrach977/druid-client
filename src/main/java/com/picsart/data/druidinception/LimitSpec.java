package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/21/16.
 */
public class LimitSpec {
    private String type;
    private String dimension;
    private String[] columns;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }


}
