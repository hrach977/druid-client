package com.picsart.data.druidinception.query;

/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class TimeSeries {
    private String queryType;
    private String dataSource;
    private Granularity granularity;
    private Descending descending;
    private Filter filter;
    private Aggregation aggregation;
    private PostAggregation postAggregation;
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

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public Descending getDescending() {
        return descending;
    }

    public void setDescending(Descending descending) {
        this.descending = descending;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Aggregation getAggregation() {
        return aggregation;
    }

    public void setAggregation(Aggregation aggregation) {
        this.aggregation = aggregation;
    }

    public PostAggregation getPostAggregation() {
        return postAggregation;
    }

    public void setPostAggregation(PostAggregation postAggregation) {
        this.postAggregation = postAggregation;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }
}
