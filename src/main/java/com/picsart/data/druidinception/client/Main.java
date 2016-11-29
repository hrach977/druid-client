package com.picsart.data.druidinception.client;

import com.picsart.data.druidinception.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avetik.sarikyan@picsart.com on 11/29/16.
 */
public class Main {
    public static void main(String[] args) {

        //Dimensions
        String[] dimensions = new String[10];
        Dimensions dims = new Dimensions();
        dims.setArray(dimensions);

        //Aggregations
        String type1 = "count";
        String name1 = "count";
        String fieldName1 = null;
        Fields agrFlds = new Fields();
        agrFlds.setType(type1);
        agrFlds.setFieldName(name1);
        agrFlds.setName(fieldName1);
        List<Fields> aggregationFields = new ArrayList<>();
        aggregationFields.add(agrFlds);
        Aggregation aggregation = new Aggregation();
        aggregation.setFields(aggregationFields);

        //Intervals
        String[] interval = new String[10];
        interval[0] = "2016-11-22T11:14:57+00:00/2016-11-29T11:14:57+00:00";
        Intervals inter = new Intervals();
        inter.setIntervals(interval);


        //LimitSpec
        String type2 = "default";
        int limit = 1000;
        String[] columns = new String[1]; //esi erb uzenq karanq poxenq
        LimitSpec limitSpec = new LimitSpec(limit, type2);
        //columns[0] = "count";
        limitSpec.setColumns(columns);

        //Granularity
        String granularity = "day";
        Granularity granularity1 = new Granularity();
        granularity1.setGranularity(granularity);

        //PostAggregations
        String type3 = null;  //es 2y hly lcnel petq chi
        String name3 = null;
        String fieldName3 = null;
        Fields postAgrFlds = new Fields();
        postAgrFlds.setType(type3);
        postAgrFlds.setFieldName(name3);
        postAgrFlds.setName(fieldName3);
        List<Fields> postaggregationFields = new ArrayList<>();
        aggregationFields.add(postAgrFlds);
        PostAggregation postaggregation = new PostAggregation();
        postaggregation.setFields(postaggregationFields);

        //Filter
        String type = null;
        String name = null;
        String fieldName = null;
        Fields fltrflds = new Fields();
        fltrflds.setType(type);
        fltrflds.setFieldName(name);
        fltrflds.setName(fieldName);
        List<Fields> filterFields = new ArrayList<>();
        filterFields.add(fltrflds);
        Filter fltr = new Filter();
        fltr.setFields(filterFields);
        fltr.setType(type);

        //DataSource
        String type4 = "table";
        String name4 = "request-kafka";
        DataSource dataSource = new DataSource();
        dataSource.setName(name4);
        dataSource.setType(type4);

        //QueryType
        String queryTypetype = "groupBy";
        QueryType queryType = new QueryType();
        queryType.setQueryType(queryTypetype);

        //Descending
        boolean forDescending = true;
        Descending descending = new Descending();
        descending.setDescending(forDescending);

        //Metric
        String[] name5 = new String[10];
        Metric metric = new Metric();
        metric.setName(name5);

        //Query
        Query query = new Query(queryType, dataSource, dims, granularity1, aggregation, inter, limitSpec);
        query.setPostAggregations(postaggregation);
    }
}
