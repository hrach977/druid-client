package com.picsart.data.druidinception.query;

/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class PagingSpec {
    private PagingIdentifiers pagingIdentifiers;
    private Threshold threshold;

    public PagingIdentifiers getPagingIdentifiers() {
        return pagingIdentifiers;
    }

    public void setPagingIdentifiers(PagingIdentifiers pagingIdentifiers) {
        this.pagingIdentifiers = pagingIdentifiers;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public void setThreshold(Threshold threshold) {
        this.threshold = threshold;
    }
}
