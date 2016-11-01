package net.yanrc.xpring.common.utils.http;

import net.yanrc.app.common.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yanricheng on 16-8-19.
 */
public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    public static final String CHARSET = "utf-8";
    public static final int DEFAULT_READ_TIMEOUT = 2000;
    public static final int DEFAULT_CONNECT_TIMEOUT = 2000;

    public static HttpResponse send(String reqUrl, HttpRequestType type, Integer connectTimeout, Integer readTimeout, Map parameterMap) {
        String response = null;
        HttpURLConnection conn = null;
        BufferedWriter writer = null;
        OutputStream os = null;
        InputStream in = null;
        BufferedReader br = null;

        try {
            URL url = new URL(reqUrl);
            conn = (HttpURLConnection) url.openConnection();

            if (readTimeout == null || readTimeout.intValue() <= 0) {
                conn.setReadTimeout(DEFAULT_READ_TIMEOUT);
            } else {
                conn.setReadTimeout(readTimeout.intValue());
            }

            if (connectTimeout == null || connectTimeout.intValue() <= 0) {
                conn.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT);
            } else {
                conn.setConnectTimeout(connectTimeout.intValue());
            }

            conn.setRequestMethod(type.toString());
            conn.setDoInput(true);
            conn.setDoOutput(true);
            os = conn.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os, CHARSET));
            writer.write(getPostDataString(parameterMap));
            writer.flush();
            writer.close();
            int responseCode = conn.getResponseCode();
            StringBuilder sb = new StringBuilder();
            in = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, CHARSET));
            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            response = sb.toString();

            if (responseCode != 200) {
                logger.warn("http 请求执行失败：url:{},method:{},parmams:{},responseCode:{},response:{} ",
                        reqUrl, type, JsonUtils.fromObject(parameterMap), responseCode, response);
                return new HttpResponse(false, responseCode, response);
            }
            return new HttpResponse(true, responseCode, response);
        } catch (Exception e) {
            logger.error("exception on send: " + e.getMessage());
            return new HttpResponse(false, -1, "");
        } finally {
            closeQuietly(os);
            closeQuietly(writer);
            closeQuietly(in);
            closeQuietly(br);
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static TreeMap<String, String> createCommonParameter() {
        TreeMap parameterMap = new TreeMap();
        String time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
        parameterMap.put("_timestamp_", time);
        return parameterMap;
    }

    private static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ioe) {
                ;
            }
        }
    }

    private static String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        Iterator itr = params.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            if (first) {
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode((String) entry.getKey(), CHARSET));
            result.append("=");
            result.append(URLEncoder.encode((String) entry.getValue(), CHARSET));
        }

        return result.toString();
    }


    public static void main(String[] args) {
        TreeMap parameter = createCommonParameter();
        parameter.put("uid", "5f25e24267c2489f9ed5cfdfb4cedfcd");
        try {
            String res = SimpleHttpRequest.newInstance().reqUrl("http://127.0.0.1:8080/api/v1/recommends")
                    .reqType(HttpRequestType.GET)
                    .addParameter("uid", "5f25e24267c2489f9ed5cfdfb4cedfcd").execute().getResBody();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
