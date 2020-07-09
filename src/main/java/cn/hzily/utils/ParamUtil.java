package cn.hzily.utils;

import java.util.Map;

public class ParamUtil {
    public static boolean emptyCheck(Object object) {
        return object != null && !"".equals(object);
    }

    public static String emptyCheck(Map<String, Object> map) {
        for (String key :
                map.keySet()) {
            if (!emptyCheck(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
