package com.neo.v1.util;


import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

public class DateUtil {

    private DateUtil() {
    }

    static final String YY_MM_DD_HH_MM_SS_FORMAT = "yyyyMMddHHmmss";
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(ofPattern(YY_MM_DD_HH_MM_SS_FORMAT));
    }

}
