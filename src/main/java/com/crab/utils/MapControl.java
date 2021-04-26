package com.crab.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Little_Crab
 * @date 2021/4/9 16:58
 */
public class MapControl {

    private static final int SUCCESS_CODE = 0;
    private static final int ERROR_CODE = 500;

    //创建一个map
    private Map<String, Object> paramMap = new HashMap<>();

    //创建无参构造方法
    public MapControl() {
    }

    //返回map
    public Map<String, Object> getMap() {
        return paramMap;
    }

    //构造一个MapParameter对象
    public static MapControl getInstance() {
        return new MapControl();
    }

    public MapControl put(String key, Object val) {
        paramMap.put(key, val);
        return this;
    }

    //向map集合中添加一个集合中的数据
    public MapControl put(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            paramMap.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public MapControl add(String key, Object val) {
        return this.put(key, val);
    }

    public MapControl success(String str) {
        return this.put("msg", str).put("code", SUCCESS_CODE);
    }

    public MapControl error(String str) {
        return this.put("msg", str).put("code", ERROR_CODE);
    }

    public MapControl success() {
        return this.put("msg", "操作成功").put("code", SUCCESS_CODE);
    }

    public MapControl error() {
        return this.put("msg", "操作失败").put("code", ERROR_CODE);
    }

    public MapControl page(List<?> data, Integer count) {
        return this.put("msg", "返回成功").put("code", SUCCESS_CODE).put("count", count).put("data", data);
    }

    public MapControl page(List<?> data, Integer count, int code) {
        return this.put("msg", "返回成功").put("code", code).put("count", count).put("data", data);
    }
}
