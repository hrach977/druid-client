package com.picsart.data.druidinception.query;

/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class Search {
    private String queryType;
    private String dataSource;
    private Granularity granularity;
    private SearchDimensions searchDimensions;
    private Sort sort;
    private String intervals;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public SearchDimensions getSearchDimensions() {
        return searchDimensions;
    }

    public void setSearchDimensions(SearchDimensions searchDimensions) {
        this.searchDimensions = searchDimensions;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }
}
