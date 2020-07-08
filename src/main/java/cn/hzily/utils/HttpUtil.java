package cn.hzily.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * http工具类，发送http请求
 */
public class HttpUtil {

    /**
     * Post方法发送form表单
     */
    public static String formForPost(String uri, Map<String, Object> params) {
        String resMsg = "";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            if (params != null) {
                PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
                String paramStr = "";
                for (String key :
                        params.keySet()) {
                    if (params.get(key) != null) {
                        paramStr += key + "=" + params.get(key) + "&";
                    }
                }
                paramStr = paramStr.substring(0, paramStr.length() - 1);
                pw.write(paramStr);
                pw.flush();
                pw.close();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            resMsg = result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resMsg;
    }

    /**
     * Post方法发送json数据
     */
    public static String jsonForPost(String uri, Map<String, Object> data) {
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

            ObjectMapper objectMapper = new ObjectMapper();
            if (data == null) {
                data = new HashMap<>();
            }
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(objectMapper.writeValueAsString(data));
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
