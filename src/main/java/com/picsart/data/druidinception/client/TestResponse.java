package com.picsart.data.druidinception.client;

/**
 * @author avetik.sarikyan@picsart.com
 */
public class TestResponse {
    private String version;
    private String timestamp;
    private String dimension;
    private long count;
    private long averageResponseTime;
    private long sumResponseTime;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(long averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public long getSumResponseTime() {
        return sumResponseTime;
    }

    public void setSumResponseTime(long sumResponseTime) {
        this.sumResponseTime = sumResponseTime;
    }
}
