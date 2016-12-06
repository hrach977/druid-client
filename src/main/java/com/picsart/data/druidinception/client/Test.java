package com.picsart.data.druidinception.client;

import com.picsart.data.druidinception.query.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avetik on 12/1/16.
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        //Dimensions
        List<String[]> dimension= new ArrayList<>();
        String[]dimensionForProtocol = new String[1];
        dimensionForProtocol[0] = "protocol";
        dimension.add(dimensionForProtocol);
        String[] dimensionForRadioType = new String[1];
        dimensionForRadioType[0] = "radio_type";
        dimension.add(dimensionForRadioType);
        String[] dimensionForContent = new String[1];
        dimensionForContent[0] = "response_type";
        dimension.add(dimensionForContent);
        String[] dimensionForCountry = new String[1];
        dimensionForCountry[0] = "country_code";
        dimension.add(dimensionForCountry);
        String[] dimensionForCareer = new String[1];
        dimensionForCareer[0] = "career";
        dimension.add(dimensionForCareer);

        //Aggregations
        String type1 = "count";
        String name1 = "count";
        int x = 2;
        Aggregation[] aggregation = new Aggregation[x];
        aggregation[0] = new Aggregation();
        aggregation[0].setName(name1);
        aggregation[0].setType(type1);
        String type7 = "doubleSum";
        String name = "sum_response_time";
        String fieldName = "sum_response_time";
        aggregation[1]= new Aggregation();
        aggregation[1].setType(type7);
        aggregation[1].setName(name);
        aggregation[1].setFieldName(fieldName);

        //Intervals
        Intervals timestamp = new Intervals();
        String intervals = timestamp.ts("2016/10/11", "2016/10/12");

        //LimitSpec
        String type2 = "default";
        int limit = 1000;
        String direction = "descending";
        String dimensionForLimitSpecForRadioType = "avg_response_time";
        Columns[] columns = new Columns[1];
        columns[0] = new Columns();
        columns[0].setDirection(direction);
        columns[0].setDimension(dimensionForLimitSpecForRadioType);
        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(limit);
        limitSpec.setType(type2);
        limitSpec.setColumns(columns);


        //Granularity
        double duration = 86400000.0/24;
        String type = "duration";
        Granularity granularity = new Granularity();
        granularity.setDuration(duration);
        granularity.setType(type);

        //PostAggregations
        PostAggregation[] postAggregation = new PostAggregation[1];
        for (int j = 0; j <postAggregation.length; j++ ){
            postAggregation[j] = new PostAggregation();
        }
        Fields[] fieldsForRadioUResponse = new Fields[2];
        fieldsForRadioUResponse[0] = new Fields();
        fieldsForRadioUResponse[1] = new Fields();
        fieldsForRadioUResponse[0].setName("sum_response_time");
        fieldsForRadioUResponse[1].setName("count");
        fieldsForRadioUResponse[0].setType("fieldAccess");
        fieldsForRadioUResponse[1].setType("fieldAccess");
        fieldsForRadioUResponse[0].setFieldName("sum_response_time");
        fieldsForRadioUResponse[1].setFieldName("count");
        postAggregation[0].setFields(fieldsForRadioUResponse);
        postAggregation[0].setType("arithmetic");
        postAggregation[0].setName("avg_response_time");
        postAggregation[0].setFn("/");

        //Filter
        Filter filter = new Filter();
        String typeForFiltering = "selector";
        String dimensionForFilter = "app";
        String valueOfFiltersDimension = "com.picsart.studio";
        filter.setType(typeForFiltering);
        filter.setDimensions(dimensionForFilter);
        filter.setValue(valueOfFiltersDimension);

        //DataSource
        String dataSource = "requests-kafka";

        //QueryType
        String queryType = "groupBy";

        //Descending
        boolean forDescending = true;
        Descending descending = new Descending();
        descending.setDescending(forDescending);

        //Metric
        String[] name5 = new String[10];
        Metric metric = new Metric();
        metric.setName(name5);

        //Query
        Query q = new Query(queryType, dataSource, dimension.get(1), granularity, aggregation, intervals, limitSpec, postAggregation);
        q.setFilter(filter);

        DruidClient druidClient = new DruidClient("107.182.229.208", 8082);
        druidClient.query(q, Response[].class);
    }
}
