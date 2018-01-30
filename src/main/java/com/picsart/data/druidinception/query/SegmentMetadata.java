package com.picsart.data.druidinception.query;

/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class SegmentMetadata {
    private String queryType;
    private String dataSource;
    private String intervals;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }
}
