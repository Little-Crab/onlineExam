package com.crab.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/9 16:58
 */
public class MapParameter {
    //创建一个map
    private Map<String, Object> paramMap = new HashMap<>();

    //创建无参构造方法
    public MapParameter() {
    }

    //返回map
    public Map<String, Object> getMap() {
        return paramMap;
    }

    //构造一个MapParameter对象
    public static MapParameter getInstance() {
        return new MapParameter();
    }

    //向map集合中添加一个集合中的数据
    public MapParameter put(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            paramMap.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public MapParameter add(Map<String, Object> map) {
        return this.put(map);
    }

    public MapParameter put(String key, Object val) {
        paramMap.put(key, val);
        return this;
    }

    public MapParameter add(String key, Object val) {
        return this.put(key, val);
    }

    //向map集合中添加id
    public MapParameter addId(Object val) {
        return this.put("id", val);
    }
}
