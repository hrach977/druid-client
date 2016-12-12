package com.picsart.data.druidinception.client;

import com.google.gson.Gson;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.picsart.data.druidinception.query.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * @author hrachya.yeghishyan@picsart.com
 * @author arman.piloyan@picsart.com
 * @author avetik.sarikyan@picsart.com
 */
public class DruidClient {
    private String host;
    private int port;

    public DruidClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public List<Response> query(Query query) {
        Gson gson = new Gson();
        String queryJson = gson.toJson(query);
        String responseString = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost postRequest = new HttpPost("http://"+host+":"+port+"/druid/v2/?pretty");
            postRequest.setHeader("Content-type", "application/json");
            StringEntity message = new StringEntity(queryJson);
            postRequest.setEntity(message);
            HttpResponse httpResponse = httpClient.execute(postRequest);
            HttpEntity entity = httpResponse.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
            JSONArray jsonArray = new JSONArray(responseString);

            List<Response> responses = new ArrayList<>();
            for(Object j : jsonArray) {
                JSONObject jsonObject = (JSONObject)j;

                Response response = new Response();
                response.setVersion(jsonObject.getString("version"));
                response.setTimestamp(jsonObject.getString("timestamp"));

                JSONObject event = jsonObject.getJSONObject("event");
                response.setCount(event.getLong("count"));

                if(event.has("sum_response_time")) {
                    response.setSumResponseTime(event.getLong("sum_response_time"));
                }
                if(event.has("avg_response_time")) {
                    response.setAverageResponseTime(event.getLong("avg_response_time"));
                }
                response.setDimension(getDimension(event));
                responses.add(response);
            }

            return responses;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getDimension(JSONObject event) {
       for(Dimension dimension : Dimension.values()) {
           String name = dimension.name().toLowerCase();
           if(event.has(name) && !event.isNull(name)) {
               return event.getString(name);
           }
       }
       return null;
    }
}