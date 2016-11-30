package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/29/16.
 */
public class Query {
    private Dimensions dimensions;
    private Aggregation[] aggregations;
    private Intervals intervals;
    private LimitSpec limitSpec;
    private Granularity granularity;
    private PostAggregation[] postAggregations;
    private QueryType queryType;
    private DataSource dataSource;

    public Query(QueryType queryType, DataSource dataSource, Dimensions dimensions, Granularity granularity, Aggregation[] aggregations, Intervals intervals, LimitSpec limitSpec){
        this.queryType = queryType;
        this.dataSource = dataSource;
        this.dimensions = dimensions;
        this.granularity = granularity;
        this.aggregations = aggregations;
        this.intervals = intervals;
        this.limitSpec = limitSpec;
    }

    public PostAggregation[] getPostAggregations() {
        return postAggregations;
    }

    public void setPostAggregations(PostAggregation[] postAggregations) {

        this.postAggregations = postAggregations;
    }
}
