package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/29/16.
 */
public class QueryGeneral {
    Dimensions[] dimensions;
    Aggregation[] aggregations;
    Intervals intervals;
    LimitSpec limitSpec;
    Granularity granularity;
    PostAggregation[] postAggregations;
    QueryType queryType;
    DataSource dataSource;

    QueryGeneral queryGeneral(QueryType queryType, DataSource dataSource, Dimensions[] dimensions, Granularity granularity, Aggregation[] aggregations, Intervals intervals){
        this.queryType = queryType;
        this.dataSource = dataSource;
        this.dimensions = dimensions;
        this.granularity = granularity;
        this.aggregations = aggregations;
        this.intervals = intervals;
    }
}
