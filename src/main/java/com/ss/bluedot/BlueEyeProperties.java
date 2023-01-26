package com.ss.bluedot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Senn
 * @date 2022/12/18 21:35
 */
public class BlueEyeProperties {

    private String path = "./blue/";

    /**
     * 纯净启动
     *  每一次启动都是最新的启动，会扫描path，删除残留数据。
     */
    private boolean pureStart = false;

    private volatile Map<String, String> propertiesMap;

    public void setProperties(String configName, String configValue) {
        getPropertiesMap().put(configName, configValue);
    }

    private Map<String, String>  getPropertiesMap() {
        if (propertiesMap == null) {
            synchronized (BlueEyeProperties.class) {
                if (propertiesMap == null) {
                    propertiesMap = new HashMap<>();
                }
            }
        }
        return propertiesMap;
    }

    public String getProperties(String ConfigName) {
        return getPropertiesMap().get(ConfigName);
    }
}
