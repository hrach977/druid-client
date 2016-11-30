package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/29/16.
 */
public class Query {
    private String[] dimensions;
    private Aggregation[] aggregations;
    private String intervals;
    private LimitSpec limitSpec;
    private Granularity granularity;
    private PostAggregation[] postAggregations;
    private String queryType;
    private String dataSource;

    public Query(String queryType, String dataSource, String[] dimensions, Granularity granularity, Aggregation[] aggregations, String intervals, LimitSpec limitSpec){
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
