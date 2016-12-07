package com.picsart.data.druidinception.query;

import java.util.List;

/**
 * @author hrachya.yeghishyan@picsart.com
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
    private Filter filter;



    public Query(String queryType, String dataSource, String[] dimensions, Granularity granularity, Aggregation[] aggregations, String intervals, LimitSpec limitSpec, PostAggregation[] postAggregations ){
        this.queryType = queryType;
        this.dataSource = dataSource;
        this.dimensions = dimensions;
        this.granularity = granularity;
        this.aggregations = aggregations;
        this.intervals = intervals;
        this.limitSpec = limitSpec;
        this.postAggregations = postAggregations;
    }
    public Query(){

    }

    public String[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(String[] dimensions) {
        this.dimensions = dimensions;
    }

    public Aggregation[] getAggregations() {
        return aggregations;
    }

    public void setAggregations(Aggregation[] aggregations) {
        this.aggregations = aggregations;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public LimitSpec getLimitSpec() {
        return limitSpec;
    }

    public void setLimitSpec(LimitSpec limitSpec) {
        this.limitSpec = limitSpec;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public PostAggregation[] getPostAggregations() {
        return postAggregations;
    }

    public void setPostAggregations(PostAggregation[] postAggregations) {
        this.postAggregations = postAggregations;
    }

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

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }


    }


