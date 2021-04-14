package com.cloud.web.util;

import java.math.BigDecimal;

public class BigDecimalUtil {
    //加法
    public static BigDecimal add(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
    //减法
    public static BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
        return num1.subtract(num2);
    }
    //乘法
    public static BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }
    //除法
    public static BigDecimal divide(BigDecimal num1, BigDecimal num2) {
        return num1.divide(num2);
    }
    //比较大小，大于返回1，等于返回0，小于返回-1
    //注意：compareTo方法比较时,不同于equals方法,需要两边都不为null,否则会报空指针异常,
    public static int compareTo(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2);
    }
    //取最大值，取两个值的大值
    public static BigDecimal max(BigDecimal num1, BigDecimal num2) {
        return num1.max(num2);
    }
    //取最小值，取两个值的小值
    public static BigDecimal min(BigDecimal num1, BigDecimal num2) {
        return num1.min(num2);
    }
}
