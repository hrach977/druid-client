package com.picsart.data.druidinception.client;

import com.picsart.data.druidinception.query.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hrachya.yeghishyan@picsart.com
 * @author arman.piloyan@picsart.com
 * @author avetik.sarikyan@picsart.com
 */
public class Test {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        String from = "2016/12/07";
        Date from1 = sdf.parse(from);
        String to = "2016/12/12";
        Date to1 = sdf.parse(to);


        Query radio_nam = RadioNamePieCHart("com.picsart.studio", from1, to1, null, null, null);
        Query radio_nam_dist = RadioNameDistribution("com.picsart.studio", from1, to1, null, null, null);
        Query cont_avg_res_time = ContentAndAvgResponseTime("com.picsart.studio", from1, to1, null, null, null);
        Query imageRequestWithResponseTime = ImageRequestWithResponseTime("com.picsart.studio", from1, to1, null, null, null,"jpeg");
        Query protocolQuery = protocolQuery("com.picsart.studio", from1, to1, null, null, null);
        Query  careerQuery = careerQuery("com.picsart.studio", from1, to1, null, null, null);
        Query countryMap = CountryMap("com.picsart.studio", from1, to1, null, null, null);

        DruidClient druidClient = new DruidClient("107.182.229.208", 8082);
        //druidClient.query(radio_nam, Response[].class);
        List<Response> r = druidClient.query(radio_nam_dist);
//        druidClient.query(cont_avg_res_time,Response[].class);
//        druidClient.query(imageRequestWithResponseTime,Response[].class);
//        druidClient.query(protocolQuery,Response[].class);
//        druidClient.query(careerQuery,Response[].class);
//        druidClient.query(countryMap,Response[].class);


    }


    public static Query RadioNamePieCHart(String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException {
        String[] dimension = new String[1];
        dimension[0] = "radio_name";
        int counter=-1;
        //Aggregation
        String type1 = "count";
        String name1 = "count";
        Aggregation[] aggregation = new Aggregation[1];
        aggregation[0] = new Aggregation();
        aggregation[0].setName(name1);
        aggregation[0].setType(type1);


        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();
        List<Field> fieldsss = new ArrayList<>();
            if(countryCode != null){
                fieldss.add(new Field());
                counter++;
                fieldss.get(counter).setDimension("country_code");
                fieldss.get(counter).setValue(countryCode);
                fieldss.get(counter).setType("selector");
            }

            if(platform !=null){
                fieldss.add(new Field());
                counter++;
                fieldss.get(counter).setDimension("platform");
                fieldss.get(counter).setValue(platform);
                fieldss.get(counter).setType("selector");
            }
            if(radioName != null){
                fieldss.add(new Field());
                counter++;
                fieldss.get(counter).setDimension("radioName");
                fieldss.get(counter).setValue(radioName);
                fieldss.get(counter).setType("selector");
            }
            if(app != null){
                fieldss.add(new Field());
                counter++;
                fieldss.get(counter).setDimension("app");
                fieldss.get(counter).setValue(app);
                fieldss.get(counter).setType("selector");
            }

        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
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
        int counter = -1;
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

        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();

        if(countryCode != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("country_code");
            fieldss.get(counter).setValue(countryCode);
            fieldss.get(counter).setType("selector");
        }

        if(platform !=null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("platform");
            fieldss.get(counter).setValue(platform);
            fieldss.get(counter).setType("selector");
        }
        if(radioName != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("radioName");
            fieldss.get(counter).setValue(radioName);
            fieldss.get(counter).setType("selector");
        }
        if(app != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("app");
            fieldss.get(counter).setValue(app);
            fieldss.get(counter).setType("selector");
        }

        filter.setFields(fieldss);
        filter.setType("and");


        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
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
        Field[] fieldsForRadioUResponse = new Field[2];
        fieldsForRadioUResponse[0] = new Field();
        fieldsForRadioUResponse[1] = new Field();
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
        int counter = -1;
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

        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();

        if(countryCode != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("country_code");
            fieldss.get(counter).setValue(countryCode);
            fieldss.get(counter).setType("selector");
        }

        if(platform !=null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("platform");
            fieldss.get(counter).setValue(platform);
            fieldss.get(counter).setType("selector");
        }
        if(radioName != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("radioName");
            fieldss.get(counter).setValue(radioName);
            fieldss.get(counter).setType("selector");
        }
        if(app != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("app");
            fieldss.get(counter).setValue(app);
            fieldss.get(counter).setType("selector");
        }

        filter.setFields(fieldss);
        filter.setType("and");

        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
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
        Field[] fieldsForRadioUResponse = new Field[2];
        fieldsForRadioUResponse[0] = new Field();
        fieldsForRadioUResponse[1] = new Field();
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
        int counter = -1;
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

        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();

        if(countryCode != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("country_code");
            fieldss.get(counter).setValue(countryCode);
            fieldss.get(counter).setType("selector");
        }

        if(platform !=null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("platform");
            fieldss.get(counter).setValue(platform);
            fieldss.get(counter).setType("selector");
        }
        if(radioName != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("radioName");
            fieldss.get(counter).setValue(radioName);
            fieldss.get(counter).setType("selector");
        }
        if(app != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("app");
            fieldss.get(counter).setValue(app);
            fieldss.get(counter).setType("selector");
        }

        if(imageType != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("response_type");
            fieldss.get(counter).setValue("image/" + imageType);
            fieldss.get(counter).setType("selector");
        }

        filter.setFields(fieldss);
        filter.setType("and");



        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
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
        Field[] fieldsForRadioUResponse = new Field[2];
        fieldsForRadioUResponse[0] = new Field();
        fieldsForRadioUResponse[1] = new Field();
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

    public static Query protocolQuery(String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException{
        String[] dimension = new String[1];
        dimension[0] = "protocol";
        int counter = -1;
        //Aggregation
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
        aggregation[1] = new Aggregation();
        aggregation[1].setType(type7);
        aggregation[1].setName(name);
        aggregation[1].setFieldName(fieldName);
        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();

        if(countryCode != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("country_code");
            fieldss.get(counter).setValue(countryCode);
            fieldss.get(counter).setType("selector");
        }

        if(platform !=null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("platform");
            fieldss.get(counter).setValue(platform);
            fieldss.get(counter).setType("selector");
        }
        if(radioName != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("radioName");
            fieldss.get(counter).setValue(radioName);
            fieldss.get(counter).setType("selector");
        }
        if(app != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("app");
            fieldss.get(counter).setValue(app);
            fieldss.get(counter).setType("selector");
        }

        filter.setFields(fieldss);
        filter.setType("and");


        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);
        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(10000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
        columns[0].setDirection("descending");
        columns[0].setDimension("avg_response_time");
        limitSpec.setColumns(columns);
        Granularity granularity = new Granularity();
        granularity.setType("duration");
        if (TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 2) {
            granularity.setDuration(86400000.0 / 24);
        }
        else if(TimeUnit.HOURS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 1)
            granularity.setDuration(86400000/(24*60));
        else
            granularity.setDuration(86400000.0);
        PostAggregation[] postAggregation = new PostAggregation[1];
        postAggregation[0] = new PostAggregation();
        Field[] fieldsForRadioUResponse = new Field[2];
        fieldsForRadioUResponse[0] = new Field();
        fieldsForRadioUResponse[1] = new Field();
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
        Query protocol = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        protocol.setFilter(filter);
        protocol.setPostAggregations(postAggregation);
        return protocol;
    }

    public static Query careerQuery (String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException{
        String[] dimension = new String[1];
        dimension[0] = "operator";
        int counter = -1;
        //Aggregation
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
        aggregation[1] = new Aggregation();
        aggregation[1].setType(type7);
        aggregation[1].setName(name);
        aggregation[1].setFieldName(fieldName);
        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();

        if(countryCode != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("country_code");
            fieldss.get(counter).setValue(countryCode);
            fieldss.get(counter).setType("selector");
        }

        if(platform !=null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("platform");
            fieldss.get(counter).setValue(platform);
            fieldss.get(counter).setType("selector");
        }
        if(radioName != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("radioName");
            fieldss.get(counter).setValue(radioName);
            fieldss.get(counter).setType("selector");
        }
        if(app != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("app");
            fieldss.get(counter).setValue(app);
            fieldss.get(counter).setType("selector");
        }

        filter.setFields(fieldss);
        filter.setType("and");

        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);
        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(10000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
        columns[0].setDirection("descending");
        columns[0].setDimension("avg_response_time");
        limitSpec.setColumns(columns);
        Granularity granularity = new Granularity();
        granularity.setType("duration");
        if (TimeUnit.DAYS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 2) {
            granularity.setDuration(86400000.0 / 24);
        }
        else if(TimeUnit.HOURS.convert(to.getTime() - from.getTime(), TimeUnit.MILLISECONDS) <= 1)
            granularity.setDuration(86400000/(24*60));
        else
            granularity.setDuration(86400000.0);
        PostAggregation[] postAggregation = new PostAggregation[1];
        postAggregation[0] = new PostAggregation();
        Field[] fieldsForRadioUResponse = new Field[2];
        fieldsForRadioUResponse[0] = new Field();
        fieldsForRadioUResponse[1] = new Field();
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
        Query career = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        career.setFilter(filter);
        career.setPostAggregations(postAggregation);
        return career;
    }

    public static Query CountryMap(String app, Date from, Date to, String countryCode, String platform, String radioName) throws ParseException {
        String[] dimension = new String[1];
        dimension[0] = "country_code";
        int counter =-1;
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

        List<Field> fieldss = new ArrayList<>();
        Filter filter = new Filter();

        if(countryCode != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("country_code");
            fieldss.get(counter).setValue(countryCode);
            fieldss.get(counter).setType("selector");
        }

        if(platform !=null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("platform");
            fieldss.get(counter).setValue(platform);
            fieldss.get(counter).setType("selector");
        }
        if(radioName != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("radioName");
            fieldss.get(counter).setValue(radioName);
            fieldss.get(counter).setType("selector");
        }
        if(app != null){
            fieldss.add(new Field());
            counter++;
            fieldss.get(counter).setDimension("app");
            fieldss.get(counter).setValue(app);
            fieldss.get(counter).setType("selector");
        }

        filter.setFields(fieldss);
        filter.setType("and");


        Intervals intervals = new Intervals();
        String inter = intervals.ts(from, to);

        LimitSpec limitSpec = new LimitSpec();
        limitSpec.setLimit(1000);
        limitSpec.setType("default");
        Column[] columns = new Column[1];
        columns[0] = new Column();
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
        Field[] fieldsForRadioUResponse = new Field[2];
        fieldsForRadioUResponse[0] = new Field();
        fieldsForRadioUResponse[1] = new Field();
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

        Query countryMap = new Query("groupBy", "requests-kafka", dimension, granularity, aggregation, inter, limitSpec);
        countryMap.setPostAggregations(postAggregation);
        countryMap.setFilter(filter);

        return countryMap;
    }

}