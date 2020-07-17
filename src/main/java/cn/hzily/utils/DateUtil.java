package cn.hzily.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类，获取常用日期格式
 */
public class DateUtil {
    /**
     * 获取日期 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
