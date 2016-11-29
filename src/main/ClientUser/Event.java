/**
 * Created by Avetik on 11/29/16.
 */
public class Event {
    private long count;
    private long averageResponseTime;
    private long numOfUniqueDeviceId;
    private long sumResponseTime;

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

    public long getNumOfUniqueDeviceId() {
        return numOfUniqueDeviceId;
    }

    public void setNumOfUniqueDeviceId(long numOfUniqueDeviceId) {
        this.numOfUniqueDeviceId = numOfUniqueDeviceId;
    }

    public long getSumResponseTime() {
        return sumResponseTime;
    }

    public void setSumResponseTime(long sumResponseTime) {
        this.sumResponseTime = sumResponseTime;
    }
}