package cn.hzily.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {


    public static void sendMessage(String msg) {
        sendMessage(msg, true);
    }

    public static void sendMessage(String msg, boolean ok) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sysMsg = sdf.format(new Date()) + " [{state}] :" + msg;
        String state = "INFO";
        if (!ok) {
            state = "ERROR";
        }
        System.out.println(sysMsg.replace("{state}", state));
    }
}
