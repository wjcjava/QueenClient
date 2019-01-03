package com.ainisi.queenmirror.common.commonutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EWorld on 2017/11/7.
 *
 * @Description:字符串处理
 */

public class StringUtil {

    public static boolean isNullOrEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    /**
     * 验证手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean checkPhoneNum(String mobiles) {
        if (isNullOrEmpty(mobiles)) return false;
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 验证字符中含有￥&%等特殊字符
     *
     * @param illegalStr
     * @return
     */
    public static boolean checkIllegalSymbol(String illegalStr) {
        if (isNullOrEmpty(illegalStr)) return false;
        Pattern p = Pattern.compile("[^%&',;=?$\\x22]+");
        Matcher m = p.matcher(illegalStr);
        return m.matches();

    }

    /**
     * @param date
     * @return
     */
    public static boolean checkDate(String date) {
        if (isNullOrEmpty(date)) return false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(System.currentTimeMillis());
        String systemDateStr = dateFormat.format(currentDate);
        String[] temp = systemDateStr.split("-");
        String systemYear = temp[0];
        String systemMonth = temp[1];
        String systemDay = temp[2];

        String[] temp2 = date.split("-");
        String chooseYear = temp2[0];
        String chooseMonth = temp2[1];
        String chooseDay = temp2[2];

        if (Integer.parseInt(chooseYear) < Integer.parseInt(systemYear)) {
            return true;
        } else if (Integer.parseInt(chooseYear) == Integer.parseInt(systemYear)) {
            if (Integer.parseInt(chooseMonth) <= Integer.parseInt(systemMonth)) {
                return true;
            }
        } else if (Integer.parseInt(chooseYear) == Integer.parseInt(systemYear) && Integer.parseInt(chooseMonth) == Integer.parseInt(systemMonth)) {
            if (Integer.parseInt(chooseDay) < Integer.parseInt(systemDay)) {
                return true;
            }
        } else {
            return false;
        }
        return false;

    }

    /**
     * 验证邮箱
     *
     * @param mailStr
     * @return
     */
    public static boolean checkMail(String mailStr) {
        if (isNullOrEmpty(mailStr)) return false;
        Pattern p = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        Matcher m = p.matcher(mailStr);
        return m.matches();
    }


}
