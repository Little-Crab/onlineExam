package com.crab.utils;

import java.io.Serializable;

/**
 * @author Little_Crab
 * @date 2021/3/30 13:49
 */
public class Entity implements Serializable {
    //为实体添加分页信息
    private Integer page;//页数
    private Integer limit;//分页条数

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
