package com.picsart.data.druidinception.client;
import java.util.Date;
/**
 * Created by Avetik on 11/29/16.
 */
public class Response {
    private String version;
    private Event event;
    private Date timeStamp;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setAverageResponseTime(long avgResponseTime) {
        event.setAverageResponseTime(avgResponseTime);
    }

    public void setCountt(long count) {
        event.setCount(count);
    }

    public void setNumOfUniqueDeviceId(long numOfUniqueDeviceId) {
        event.setNumOfUniqueDeviceId(numOfUniqueDeviceId);
    }

    public void setSumResponseTime(long sumResponseTime) {
        event.setSumResponseTime(sumResponseTime);
    }

    public void getAvgResponseTime(long avgResponseTime) {
        event.getAverageResponseTime();
    }

    public long getCount() {
         return event.getCount();
    }

    public void getNumOfUniqueDeviceId(long numOfUniqueDeviceId) {
        event.getNumOfUniqueDeviceId();
    }

    public void getSumResponseTime(long sumResponseTime) {
        event.getSumResponseTime();
    }
}
