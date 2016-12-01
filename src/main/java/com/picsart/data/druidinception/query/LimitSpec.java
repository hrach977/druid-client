package com.picsart.data.druidinception.query;

/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class LimitSpec {
    private int limit;
    private String type;
    private Columns[] columns;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Columns[] getColumns() {
        return columns;
    }

    public void setColumns(Columns[] columns) {
        this.columns = columns;
    }

}
