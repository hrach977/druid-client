package com.picsart.data.druidinception;

import sun.security.krb5.internal.crypto.Des;



/**
 * Created by hrachyeghishyan on 11/21/16.
 */
public class Select {
    QueryType queryType;
    DataSource dataSource;
    Descending descending;
    Dimensions dimension;
    Metric metric;
    Granularity granularity;
    Intervals intervals;
    PagingSpec pagingSpec;
}
