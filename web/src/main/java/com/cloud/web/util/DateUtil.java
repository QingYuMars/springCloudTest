package com.cloud.web.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    /**
     * 如果是字符串需要先转成date 再调用 dateToISODate() 方法
     * @param strDate
     * @return
     */
    public static LocalDateTime strToDateLong(String strDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(strDate, df);
        return dateTime;
    }


    public static void main(String[] args) {

    }
}
