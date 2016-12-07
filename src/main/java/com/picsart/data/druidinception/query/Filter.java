package com.picsart.data.druidinception.query;

import java.util.List;
/**
 * @author hrachya.yeghishyan@picsart.com
 */
public class Filter {
    private List<Fields> fields;

    public List<Fields> getFields() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }
}

   // private Fields[] fields;
//
//    public Fields[] getFields() {
//        return fields;
//    }
//
//    public void setFields(Fields[] fields) {
//        this.fields = fields;
//    }

//    private String type;
//    private String dimension;
//    private String value;

//    public String getDimensions() {
//        return dimension;
//    }
//
//    public void setDimensions(String dimensions) {
//        this.dimension = dimensions;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }


//    public Filter getAppFilter(){
//        Filter filter = new Filter();
//        String typeForFiltering = "selector";
//        String dimensionForFilter = "app";
//        String valueOfFiltersDimension = "com.picsart.studio";
//        filter.setType(typeForFiltering);
//        filter.setDimensions(dimensionForFilter);
//        filter.setValue(valueOfFiltersDimension);
//
//        return filter;//
//    }