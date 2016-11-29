package com.picsart.data.druidinception;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json_Send {

    
    public String postJSON() {

        String responseString = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost postRequest = new HttpPost("http://107.182.229.208:8082/druid/v2/?pretty");
            postRequest.setHeader("Content-type", "application/json");
//            StringEntity message = new StringEntity();
//            postRequest.setEntity(message);
            HttpResponse response = httpClient.execute(postRequest);
            HttpEntity entity = response.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);


        } catch (Exception e) {

        }


        return responseString;
    }

    public void returnVal(String response, String groupBy, String metrics) throws Exception {
        Double numVal;
        String strVal;
        List<Data> dataSet = new ArrayList<Data>();

        Gson gson = new Gson();
        JsonElement[] elements = gson.fromJson(response, JsonElement[].class);

    }



}













