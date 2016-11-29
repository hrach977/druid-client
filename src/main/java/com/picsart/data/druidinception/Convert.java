package com.picsart.data.druidinception;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.JsonElement;
import java.lang.String;
import org.apache.http.entity.StringEntity;

//swith statementov, kaxvac useri koxmic trvac int-i arjeqi, parse anel tbyal int-in hamapatasxanox classi jsony
//bayc switchi vaxt el eli meka string a linelu

/**
 * Created by hrachyeghishyan on 11/18/16.
 */
public class Convert{
    public static void main(String[] args) {
        Gson gson = new Gson();
        JsonObject json = null;
        try {
            json = gson.fromJson(new FileReader(args[0]), JsonObject.class); //??not sure
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String dzev = json.get("queryType").getAsString(); //won't the filed "queryType" always be present
        TimeSeries tSeries = new TimeSeries();
        TopN tN = new TopN();
        GroupBy gB = new GroupBy();
        TimeBoundary tBound = new TimeBoundary();
        SegmentMetadata sMeta = new SegmentMetadata();
        DataSource dSource = new DataSource();
        Search srch = new Search();
        Select slct = new Select();

        StringEntity stringJson = gson.fromJson(json, StringEntity.class);

        switch(dzev.toLowerCase()){     //es momenty mi hat petqa veranayel
            case "timeseries": {
                tSeries = gson.fromJson(json, TimeSeries.class);    //sra u mnacaci argumentneri mej, json-i texy, voncor petqa resulting jsony lini
            }                                                       //bayc myus koxmic el, vereviny voncor sxal tesaketa
                break;
            case "topn":   tN = gson.fromJson(json, TopN.class);
                break;
            case "groupby": gB = gson.fromJson(json, GroupBy.class);
                break;
            case "timeboundary":  tBound = gson.fromJson(json, TimeBoundary.class);
                break;
            case "segmentmatadata":  sMeta = gson.fromJson(json, SegmentMetadata.class);
                break;
            case "datasource":  dSource = gson.fromJson(json, DataSource.class);
                break;
            case  "search":  srch = gson.fromJson(json, Search.class);
                break;
            case "select":  slct = gson.fromJson(json, Select.class);
                break;
            default:
                break;
        }





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
        Query<z> asd = new Query(); //merely the same name is not enough, directly the class is needed

        Gson gson = new Gson();
        //so why not in case of T?
        Query<Integer> b = new Query();
        Query<TimeSeries> c = new Query();

        String h = FileUtils.readFileToString(args[1]);

        String userType = args[1];
        switch (userType){

        }

        try {
           Query<h> a= new Query();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            Query query = gson.fromJson(new FileReader(args[0]), Query.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } */