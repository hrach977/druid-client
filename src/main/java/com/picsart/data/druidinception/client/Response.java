package com.picsart.data.druidinception.client;
import java.security.Timestamp;
import java.util.Date;

/**
 * @author avetik.sarikyan@picsart.com
 */
public class Response {
    private String version;
    private Event event;
    private Date timestamp;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public long getAvgResponseTime() {
        return event.getAverageResponseTime();
    }

    public long getCount() {
         return event.getCount();
    }

    public long getNumOfUniqueDeviceId() {
        return event.getNumOfUniqueDeviceId();
    }

    public long getSumResponseTime()  {
        return event.getSumResponseTime();
    }
}
