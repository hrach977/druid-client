package com.picsart.data.druidinception;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonElement;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import com.picsart.data.druidinception.client.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.util.EntityUtils;

//swith statementov, kaxvac useri koxmic trvac int-i arjeqi, parse anel tbyal int-in hamapatasxanox classi jsony
//bayc switchi vaxt el eli meka string a linelu

/**
 * Created by hrachyeghishyan on 11/18/16.
 */
public class Convert{
    public static void main(String[] args) {
        Gson gson = new Gson();
        JsonObject json = null;
//        try {
//            json = gson.fromJson(new FileReader(args[0]), JsonObject.class); //??not sure
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        String dzev = json.get("queryType").getAsString(); //won't the filed "queryType" always be present
//        TimeSeries tSeries = new TimeSeries();
//        TopN tN = new TopN();
//        GroupBy gB = new GroupBy();
//        TimeBoundary tBound = new TimeBoundary();
//        SegmentMetadata sMeta = new SegmentMetadata();
//        DataSource dSource = new DataSource();
//        Search srch = new Search();
//        Select slct = new Select();

        //StringEntity stringJson = gson.fromJson(json, StringEntity.class);

//es takinnery navsyaki comment
//        switch(dzev.toLowerCase()){     //es momenty mi hat petqa veranayel
//            case "timeseries": {
//                tSeries = gson.fromJson(json, TimeSeries.class);    //sra u mnacaci argumentneri mej, json-i texy, voncor petqa resulting jsony lini
//            }                                                       //bayc myus koxmic el, vereviny voncor sxal tesaketa
//                break;
//            case "topn":   tN = gson.fromJson(json, TopN.class);
//                break;
//            case "groupby": gB = gson.fromJson(json, GroupBy.class);
//                break;
//            case "timeboundary":  tBound = gson.fromJson(json, TimeBoundary.class);
//                break;
//            case "segmentmatadata":  sMeta = gson.fromJson(json, SegmentMetadata.class);
//                break;
//            case "datasource":  dSource = gson.fromJson(json, DataSource.class);
//                break;
//            case  "search":  srch = gson.fromJson(json, Search.class);
//                break;
//            case "select":  slct = gson.fromJson(json, Select.class);
//                break;
//            default:
//                break;
//        }

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

        String jsonString = gson.toJson(query);

//zabor
        String responseString = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost postRequest = new HttpPost("http://107.182.229.208:8082/druid/v2/?pretty");
            postRequest.setHeader("Content-type", "application/json");
            StringEntity message = new StringEntity(jsonString);
            postRequest.setEntity(message);
            HttpResponse response = httpClient.execute(postRequest);
            HttpEntity entity = response.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Response[] elements = gson.fromJson(responseString, Response[].class);

        System.out.println(elements[0].getTimeStamp());
        System.out.println(elements[0].getCount());

    }
}





// JSONObject tesak = json.get("queryType");


  /*  Gson gson = new Gson();
        try {
                TimeSeries tSeries = gson.fromJson(new FileReader(args[0]), TimeSeries.class);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }

        JsonElement json = null;
        try {
        json = gson.fromJson(new FileReader(args[0]), JsonElement.class);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        }
        String resultingJson = gson.toJson(json);

//switch grel, json-ic vercem querytype-y, u yst aydm xodi tal





/* //T-n kardal mi texic, vori mej usery kgri
        //
        String z = "TopN";
        QueryNotNeededYet<z> asd = new QueryNotNeededYet(); //merely the same name is not enough, directly the class is needed

        Gson gson = new Gson();
        //so why not in case of T?
        QueryNotNeededYet<Integer> b = new QueryNotNeededYet();
        QueryNotNeededYet<TimeSeries> c = new QueryNotNeededYet();

        String h = FileUtils.readFileToString(args[1]);

        String userType = args[1];
        switch (userType){

        }

        try {
           QueryNotNeededYet<h> a= new QueryNotNeededYet();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            QueryNotNeededYet query = gson.fromJson(new FileReader(args[0]), QueryNotNeededYet.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } */