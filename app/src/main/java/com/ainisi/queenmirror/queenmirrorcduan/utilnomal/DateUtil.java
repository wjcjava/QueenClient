package com.ainisi.queenmirror.queenmirrorcduan.utilnomal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 一小时的秒数
     */
    private static final int HOUR_SECOND = 60 * 60;

    /**
     * 一分钟的秒数
     */
    private static final int MINUTE_SECOND = 60;

    public static String getCurrentDateTime(String format) {

        SimpleDateFormat myFmt=new SimpleDateFormat(format);

        Date now=new Date();

        return myFmt.format(now);
    }


    /**
     * 根据秒数获取时间串
     * @param second (eg: 100s)
     * @return (eg: 00:01:40)
     */
    public static String getTimeStrBySecond(int second) {
        if (second <= 0) {

            return "00:00";
        }

        StringBuilder sb = new StringBuilder();
        int hours = second / HOUR_SECOND;
        if (hours > 0) {

            second -= hours * HOUR_SECOND;
        }

        int minutes = second / MINUTE_SECOND;

        return (hours > 10 ? (hours + "")
                : ("0" + hours) + ":" + (minutes > 10 ? (minutes + "") : ("0" + minutes)));
    }
}
