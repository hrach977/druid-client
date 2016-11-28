package com.picsart.data.druidinception;

import java.util.List;
/**
 * Created by hrachyeghishyan on 11/21/16.
 */
public class TimeSeries {
    QueryType queryType;
    DataSource dataSource;
    Granularity granularity;
    Descending descending;
    Filter filter;
    //List<Fields> fields;  is already included in Filter
    Aggregation aggregation;
    PostAggregation postAggregation;
    Intervals intervals;


}
