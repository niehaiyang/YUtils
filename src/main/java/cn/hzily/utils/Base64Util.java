package cn.hzily.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {
    public static String encode(String inStr) {
        return Base64.getEncoder().encodeToString(inStr.getBytes(StandardCharsets.UTF_8));
    }

    public static String encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decodeStr(String inStr) {
        return new String(decode(inStr), StandardCharsets.UTF_8);
    }

    public static byte[] decode(String inStr) {
        return Base64.getDecoder().decode(inStr);
    }
}
