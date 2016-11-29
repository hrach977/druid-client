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

        //Granularity
        String granularity = null;
        Granularity granularity1 = new Granularity();
        granularity1.setGranularity(granularity);

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

        //Aggregations
        String type1 = null;
        String name1 = null;
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
        Intervals inter = new Intervals();
        inter.setIntervals(interval);

        //LimitSpec
        String type2 = null;
        String dimension = null;
        String[] columns = new String[10];
        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setType(type2);
        limitSpec.setColumns(columns);
        limitSpec.setDimension(dimension);

        //PostAggregations
        String type3 = null;
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

        //DataSource
        String type4 = null;
        String name4 = null;
        DataSource dataSource = new DataSource();
        dataSource.setName(name4);
        dataSource.setType(type4);

        //QuerryType (Need to figure it out)

        //Descending
        boolean forDescending = true;
        Descending descending = new Descending();
        descending.setDescending(forDescending);

        //Metric
        String[] name5 = new String[10];
        Metric metric = new Metric();
        metric.setName(name5);

    }
}
