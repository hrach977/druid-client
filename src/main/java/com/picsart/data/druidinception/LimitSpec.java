package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/21/16.
 */
public class LimitSpec {
    private String type;
    //private String dimension;
    private String[] columns;
    private long limit;

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   /* public String getDimension() {
        return dimension;
    }*/

//    public void setDimension(String dimension) {
//        this.dimension = dimension;
//    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }


}
