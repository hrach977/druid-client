package com.picsart.data.druidinception;

/**
 * Created by hrachyeghishyan on 11/17/16.
 */
public class QueryNotNeededYet<T> {    //probably meaningless
   // private T asdf;
    private Class<T> t;

    public QueryNotNeededYet(Class<T> t){
        this.t = t;
    }

    public T biuldOne() throws InstantiationException, IllegalAccessException{
        return t.newInstance();
    }

}


