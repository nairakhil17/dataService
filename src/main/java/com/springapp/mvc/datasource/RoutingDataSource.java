package com.springapp.mvc.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by akhil on 7/7/16.
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return holder.get();
    }

//    @Override
    public static void setDataSourceKey(String key) {
        holder.set(key);
    }
}
