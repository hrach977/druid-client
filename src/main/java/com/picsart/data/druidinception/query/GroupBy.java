package com.picsart.data.druidinception.query;


/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class GroupBy {
    private String queryType;
    private String dataSource;
    private Granularity granularity;
    private String dimension;
    private LimitSpec limitSpec;
    private Filter filter;
    private Aggregation aggregation;
    private PostAggregation postAggregation;
    private Intervals intervals;
    private Having having;

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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public LimitSpec getLimitSpec() {
        return limitSpec;
    }

    public void setLimitSpec(LimitSpec limitSpec) {
        this.limitSpec = limitSpec;
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

    public Intervals getIntervals() {
        return intervals;
    }

    public void setIntervals(Intervals intervals) {
        this.intervals = intervals;
    }

    public Having getHaving() {
        return having;
    }

    public void setHaving(Having having) {
        this.having = having;
    }
}
