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

    public <T> T query(Query query, Class<T> clazz) {
        Gson gson = new Gson();
        String queryJson = gson.toJson(query);

        String responseString = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost postRequest = new HttpPost("http://"+host+":"+port+"/druid/v2/?pretty");
            postRequest.setHeader("Content-type", "application/json");
            StringEntity message = new StringEntity(queryJson);
            postRequest.setEntity(message);
            HttpResponse response = httpClient.execute(postRequest);
            HttpEntity entity = response.getEntity();
            responseString = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gson.fromJson(responseString, clazz);
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