package com.crab.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Little_Crab
 * @date 2021/3/28 14:26
 */
public class DateConvert implements Converter<String, Date> {

    //定义一个Convert用来进行将字符串转换为Date 日期数据
    @Override
    public Date convert(String s) {
        try {
            //使用SimpleDateFormat进行对字符串进行格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //返回日期数据
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
