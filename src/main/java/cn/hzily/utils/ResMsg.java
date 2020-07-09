package cn.hzily.utils;

import com.alibaba.fastjson.JSONObject;

public class ResMsg {
    public static String msg(boolean state, String code, String msg, Object... data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", state);
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        if (data != null && data.length > 0) {
            jsonObject.put("data", data);
        }
        return jsonObject.toString();
    }

    public static String ok(Object... data) {
        return ok("成功", data);
    }

    public static String ok(String msg, Object... data) {
        return msg(true, "200", msg, data);
    }

    public static String fail(String msg, String errCode, Object... data) {
        return msg(false, errCode, msg, data);
    }
}
