package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/21/16.
 */
public class Search {
    QueryType queryType;
    DataSource dataSource;
    Granularity granularity;
    SearchDimensions searchDimensions;
    Qry qry;  //in order not to merge with the generaic class QueryNotNeededYet<T>
    Sort sort;
    Intervals intervals;
}
