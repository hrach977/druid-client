package com.picsart.data.druidinception.client;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.picsart.data.druidinception.query.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Avetik on 12/1/16.
 */
public class Test {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        String from = "2016/12/02";
        Date from1 = sdf.parse(from);
        String to = "2016/12/05";
        Date to1 = sdf.parse(to);


        Query radio_nam = ImageRequestWithResponseTime(null, from1, to1, "AM", null, null, "jpeg");
        DruidClient druidClient = new DruidClient("107.182.229.208", 8082);
        druidClient.query(radio_nam, Response[].class);


    }


    public static Query RadioNamePieCHart(String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException {
        String[] dimension = new String[1];
        dimension[0] = "radio_name";
        //Aggregation
        String type1 = "count";
        String name1 = "count";
        Aggregation[] aggregation = new Aggregation[1];
        aggregation[0] = new Aggregation();
        aggregation[0].setName(name1);
        aggregation[0].setType(type1);


        List<Fields> fieldss = new ArrayList<>();
        Filter filter = new Filter();
        List<String> filterDimension = new ArrayList<>();
        List<String> filterValue = new ArrayList<>();
        if ((app != null && countryCode != null) || (app != null && platform != null) || (app != null && radioName != null) || (countryCode != null && platform != null) || (countryCode != null && radioName != null) || (platform != null && radioName != null)) {
            filterDimension.add("app");
            filterDimension.add("country_code");
            filterDimension.add("platform");
            filterDimension.add("radio_name");

            filterValue.add(app);
            filterValue.add(countryCode);
            filterValue.add(platform);
            filterValue.add(radioName);

            for (int i = 0; i < 4; i++) {
                fieldss.add(new Fields());
                if (filterValue.get(i) != null) {
                    fieldss.get(i).setDimension(filterDimension.get(i));
                    fieldss.get(i).setValue(filterValue.get(i));
                    fieldss.get(i).setType("selector");
                }
                else {
                    fieldss.set(i,null);
                }
            }
            filter.setFields(fieldss);
            filter.setType("and");
        } else if (app != null) {
            filter.setDimension("app");
            filter.setValue(app);
            filter.setType("selector");
        } else if (countryCode != null) {
            filter.setDimension("country_code");
            filter.setValue(countryCode);
            filter.setType("selector");
        } else if (platform != null) {
            filter.setDimension("platform");
            filter.setValue(platform);
            filter.setType("selector");
        } else if (radioName != null) {
            filter.setDimension("radio_name");
            filter.setValue(radioName);
            filter.setType("selector");
        }
        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Columns[] columns = new Columns[1];
        columns[0] = new Columns();
        columns[0].setDirection("descending");
        columns[0].setDimension("count");
        limitSpec.setColumns(columns);

        Granularity granularity = new Granularity();
        granularity.setType("duration");
        if (TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 2) {
            granularity.setDuration(86400000.0 / 24);
        } else if (TimeUnit.HOURS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 1)
            granularity.setDuration(86400000 / (24 * 60));
        else
            granularity.setDuration(86400000.0);

        Query radio_namePie = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        radio_namePie.setFilter(filter);

        return radio_namePie;
    }

    public static Query RadioNameDistribution(String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException {
        String[] dimension = new String[1];
        dimension[0] = "radio_name";
        //Aggregation
        String type1 = "count";
        String name1 = "count";
        Aggregation[] aggregation = new Aggregation[2];
        aggregation[0] = new Aggregation();
        aggregation[0].setName(name1);
        aggregation[0].setType(type1);
        String type7 = "doubleSum";
        String name = "sum_response_time";
        String fieldName = "sum_response_time";
        aggregation[1] = new Aggregation();
        aggregation[1].setType(type7);
        aggregation[1].setName(name);
        aggregation[1].setFieldName(fieldName);

        List<Fields> fieldss = new ArrayList<>();
        Filter filter = new Filter();
        List<String> filterDimension = new ArrayList<>();
        List<String> filterValue = new ArrayList<>();
        if ((app != null && countryCode != null) || (app != null && platform != null) || (app != null && radioName != null) || (countryCode != null && platform != null) || (countryCode != null && radioName != null) || (platform != null && radioName != null)) {
            filterDimension.add("app");
            filterDimension.add("country_code");
            filterDimension.add("platform");
            filterDimension.add("radio_name");

            filterValue.add(app);
            filterValue.add(countryCode);
            filterValue.add(platform);
            filterValue.add(radioName);

            for (int i = 0; i < 4; i++) {
                fieldss.add(new Fields());
                if (filterValue.get(i) != null) {
                    fieldss.get(i).setDimension(filterDimension.get(i));
                    fieldss.get(i).setValue(filterValue.get(i));
                    fieldss.get(i).setType("selector");
                }
                else {
                    fieldss.set(i,null);
                }
            }
            filter.setFields(fieldss);
            filter.setType("and");
        } else if (app != null) {
            filter.setDimension("app");
            filter.setValue(app);
            filter.setType("selector");
        } else if (countryCode != null) {
            filter.setDimension("country_code");
            filter.setValue(countryCode);
            filter.setType("selector");
        } else if (platform != null) {
            filter.setDimension("platform");
            filter.setValue(platform);
            filter.setType("selector");
        } else if (radioName != null) {
            filter.setDimension("radio_name");
            filter.setValue(radioName);
            filter.setType("selector");
        }
        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Columns[] columns = new Columns[1];
        columns[0] = new Columns();
        columns[0].setDirection("descending");
        columns[0].setDimension("avg_response_time");
        limitSpec.setColumns(columns);

        Granularity granularity = new Granularity();
        granularity.setType("duration");
        if (TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 2) {
            granularity.setDuration(86400000.0 / 24);
        } else if (TimeUnit.HOURS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 1)
            granularity.setDuration(86400000 / (24 * 60));
        else
            granularity.setDuration(86400000.0);

        PostAggregation[] postAggregation = new PostAggregation[1];
        postAggregation[0] = new PostAggregation();
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

        Query radio_name = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        radio_name.setPostAggregations(postAggregation);
        radio_name.setFilter(filter);

        return radio_name;
    }

    public static Query ContentAndAvgResponseTime(String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException {
        String[] dimension = new String[1];
        dimension[0] = "response_type";
        //Aggregation
        String type1 = "count";
        String name1 = "count";
        Aggregation[] aggregation = new Aggregation[2];
        aggregation[0] = new Aggregation();
        aggregation[0].setName(name1);
        aggregation[0].setType(type1);
        String type7 = "doubleSum";
        String name = "sum_response_time";
        String fieldName = "sum_response_time";
        aggregation[1] = new Aggregation();
        aggregation[1].setType(type7);
        aggregation[1].setName(name);
        aggregation[1].setFieldName(fieldName);

        List<Fields> fieldss = new ArrayList<>();
        Filter filter = new Filter();
        List<String> filterDimension = new ArrayList<>();
        List<String> filterValue = new ArrayList<>();
        if ((app != null && countryCode != null) || (app != null && platform != null) || (app != null && radioName != null) || (countryCode != null && platform != null) || (countryCode != null && radioName != null) || (platform != null && radioName != null)) {
            filterDimension.add("app");
            filterDimension.add("country_code");
            filterDimension.add("platform");
            filterDimension.add("radio_name");

            filterValue.add(app);
            filterValue.add(countryCode);
            filterValue.add(platform);
            filterValue.add(radioName);

            for (int i = 0; i < 4; i++) {
                fieldss.add(new Fields());
                if (filterValue.get(i) != null) {
                    fieldss.get(i).setDimension(filterDimension.get(i));
                    fieldss.get(i).setValue(filterValue.get(i));
                    fieldss.get(i).setType("selector");
                }
                else {
                    fieldss.set(i,null);
                }
            }
            filter.setFields(fieldss);
            filter.setType("and");
        } else if (app != null) {
            filter.setDimension("app");
            filter.setValue(app);
            filter.setType("selector");
        } else if (countryCode != null) {
            filter.setDimension("country_code");
            filter.setValue(countryCode);
            filter.setType("selector");
        } else if (platform != null) {
            filter.setDimension("platform");
            filter.setValue(platform);
            filter.setType("selector");
        } else if (radioName != null) {
            filter.setDimension("radio_name");
            filter.setValue(radioName);
            filter.setType("selector");
        }
        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Columns[] columns = new Columns[1];
        columns[0] = new Columns();
        columns[0].setDirection("descending");
        columns[0].setDimension("avg_response_time");
        limitSpec.setColumns(columns);

        Granularity granularity = new Granularity();
        granularity.setType("duration");
        if (TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 2) {
            granularity.setDuration(86400000.0 / 24);
        } else if (TimeUnit.HOURS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 1)
            granularity.setDuration(86400000 / (24 * 60));
        else
            granularity.setDuration(86400000.0);

        PostAggregation[] postAggregation = new PostAggregation[1];
        postAggregation[0] = new PostAggregation();
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

        Query content = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        content.setPostAggregations(postAggregation);
        content.setFilter(filter);

        return content;
    }

    public static Query ImageRequestWithResponseTime(String app, Date from, Date to, String countryCode, String platform, String radioName, String imageType) throws ParseException {
        String[] dimension = new String[1];
        dimension[0] = "response_type";
        //Aggregation
        String type1 = "count";
        String name1 = "count";
        Aggregation[] aggregation = new Aggregation[2];
        aggregation[0] = new Aggregation();
        aggregation[0].setName(name1);
        aggregation[0].setType(type1);
        String type7 = "doubleSum";
        String name = "sum_response_time";
        String fieldName = "sum_response_time";
        aggregation[1] = new Aggregation();
        aggregation[1].setType(type7);
        aggregation[1].setName(name);
        aggregation[1].setFieldName(fieldName);

        List<Fields> fieldss = new ArrayList<>();

        Filter filter = new Filter();

        List<String> filterDimension = new ArrayList<>();
        List<String> filterValue = new ArrayList<>();
        if ((app != null && countryCode != null) || (app != null && platform != null) ||
                (app != null && radioName != null) || (countryCode != null && platform != null) ||
                    (countryCode != null && radioName != null) || (platform != null && radioName != null)||
                        (app != null && imageType != null) || (countryCode != null && imageType != null) ||
                            ( platform != null && imageType != null) || (radioName != null &&   imageType != null)) {
            filterDimension.add("app");
            filterDimension.add("country_code");
            filterDimension.add("platform");
            filterDimension.add("radio_name");
            filterDimension.add("response_type");

            filterValue.add(app);
            filterValue.add(countryCode);
            filterValue.add(platform);
            filterValue.add(radioName);
            filterValue.add("image/"+ imageType);

            for (int i = 0; i < 5; i++) {
                fieldss.add(new Fields());
                if (filterValue.get(i) != null) {
                    fieldss.get(i).setDimension(filterDimension.get(i));
                    fieldss.get(i).setValue(filterValue.get(i));
                    fieldss.get(i).setType("selector");
                }
                else {
                    fieldss.set(i,null);
                }
            }
            filter.setFields(fieldss);
            filter.setType("and");

        }
        else if(imageType != null){
            filter.setDimension("response_type");
            filter.setValue("image/" + imageType);
            filter.setType("selector");
        }
        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Columns[] columns = new Columns[1];
        columns[0] = new Columns();
        columns[0].setDirection("descending");
        columns[0].setDimension("avg_response_time");
        limitSpec.setColumns(columns);

        Granularity granularity = new Granularity();
        granularity.setType("duration");
        if (TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 2) {
            granularity.setDuration(86400000.0 / 24);
        } else if (TimeUnit.HOURS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 1)
            granularity.setDuration(86400000 / (24 * 60));
        else
            granularity.setDuration(86400000.0);

        PostAggregation[] postAggregation = new PostAggregation[1];
        postAggregation[0] = new PostAggregation();
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

        Query response_type = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        response_type.setPostAggregations(postAggregation);
        response_type.setFilter(filter);

        return response_type;
    }




}