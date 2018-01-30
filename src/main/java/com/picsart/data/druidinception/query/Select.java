package com.picsart.data.druidinception.query;


/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class Select {
    private String queryType;
    private String dataSource;
    private Descending descending;
    private String dimension;
    private Metric metric;
    private Granularity granularity;
    private String intervals;
    private PagingSpec pagingSpec;


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

    public Descending getDescending() {
        return descending;
    }

    public void setDescending(Descending descending) {
        this.descending = descending;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public PagingSpec getPagingSpec() {
        return pagingSpec;
    }

    public void setPagingSpec(PagingSpec pagingSpec) {
        this.pagingSpec = pagingSpec;
    }
}
