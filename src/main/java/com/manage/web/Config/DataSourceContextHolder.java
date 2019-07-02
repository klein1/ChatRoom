package com.manage.web.Config;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2017/3/25.
 */
public class DataSourceContextHolder {
    public static final String DATA_SOURCE_MYSQL = "dataSource";
    public static final String DATA_SOURCE_MYSQL2 = "dataSource2";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDbType(String dbType){
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        String dataSource = contextHolder.get();
        if (StringUtils.isEmpty(dataSource)) {
            return DATA_SOURCE_MYSQL;
        }else {
            return dataSource;
        }
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
