package com.ranjun1999.personalutils.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * http请求
 *
 * @author ycw
 */
public class HttpUtils {


    /**
     * 发送GET请求
     *
     * @param urlString URL地址
     * @return 响应
     * @throws IOException
     */
    public static String sendGet(String urlString) throws IOException {
        return send(urlString, "GET", null, null);
    }

    /**
     * 发送GET请求
     *
     * @param urlString URL地址
     * @param params    参数集合
     * @return 响应
     * @throws IOException
     */
    public static String sendGet(String urlString, Map<String, String> params) throws IOException {
        return send(urlString, "GET", params, null);
    }

    /**
     * 发送GET请求
     *
     * @param urlString URL地址
     * @param params    参数集合
     * @param propertys 请求属性
     * @return 响应
     * @throws IOException
     */
    public static String sendGet(String urlString, Map<String, String> params, Map<String, String> propertys)
            throws IOException {
        return send(urlString, "GET", params, propertys);
    }

    /**
     * 发送POST请求
     *
     * @param urlString URL地址
     * @return 响应
     * @throws IOException
     */
    public static String sendPost(String urlString) throws IOException {
        return send(urlString, "POST", null, null);
    }

    /**
     * 发送POST请求
     *
     * @param urlString URL地址
     * @param params    参数集合
     * @return 响应
     * @throws IOException
     */
    public static String sendPost(String urlString, Map<String, String> params) throws IOException {
        return send(urlString, "POST", params, null);
    }

    /**
     * 发送POST请求
     *
     * @param urlString URL地址
     * @param params    参数集合
     * @param propertys 请求属性
     * @return 响应
     * @throws IOException
     */
    public static String sendPost(String urlString, Map<String, String> params, Map<String, String> propertys)
            throws IOException {
        return send(urlString, "POST", params, propertys);
    }

    /**
     * 发送HTTP请求
     *
     * @param urlString
     * @return 响映
     * @throws IOException
     */
    private static String send(String urlString, String method, Map<String, String> parameters,
                               Map<String, String> propertys) throws IOException {
        HttpURLConnection conn = null;

        if (method.equalsIgnoreCase("GET") && parameters != null) {
            StringBuffer param = new StringBuffer();
            int i = 0;
            for (String key : parameters.keySet()) {
                if (i == 0)
                    param.append("?");
                else
                    param.append("&");
                param.append(key).append("=").append(parameters.get(key));
                i++;
            }
            urlString += param;
        }
        URL url = new URL(urlString);
        conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod(method);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);

        if (propertys != null)
            for (String key : propertys.keySet()) {
                conn.addRequestProperty(key, propertys.get(key));
            }

        if (method.equalsIgnoreCase("POST") && parameters != null) {
            StringBuffer param = new StringBuffer();
            for (String key : parameters.keySet()) {
                param.append("&");
                param.append(key).append("=").append(parameters.get(key));
            }
            conn.getOutputStream().write(param.toString().getBytes());
            conn.getOutputStream().flush();
            conn.getOutputStream().close();
        }

        return getResponse(urlString, conn);
    }

    /**
     * 得到响应对
     *
     * @param urlConnection
     * @return 响应
     * @throws IOException
     */
    private static String getResponse(String urlString, HttpURLConnection conn) throws IOException {
        try {
            InputStream in = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuffer result = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            bufferedReader.close();

            return result.toString();
        } catch (IOException e) {
            throw e;
        } finally {
            if (conn != null)
                conn.disconnect();
        }
    }

    public static String sendPostByHttpClient(String urlString, Map<String,String> properties, String param) {
        try {

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(urlString);

//            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(param, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);

            for (String s : properties.keySet()) {
                httpPost.addHeader(s,properties.get(s));
            }

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {//
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            return httpclient.execute(httpPost, responseHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String sendGetByHttpClient(String urlString) {

        try {

            CloseableHttpClient httpclient = HttpClients.createDefault();
            // System.out.println(json);

            HttpGet httpGet = new HttpGet(urlString);
            httpGet.addHeader("Content-Type", "application/json;charset=UTF-8");

            // 解决中文乱码问题
//			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
//			stringEntity.setContentEncoding("UTF-8");

            // CloseableHttpResponse response =
            // httpclient.execute(httpPost);

            // System.out.println("Executing request " +
            // httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {//
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {

                        HttpEntity entity = response.getEntity();

                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpGet, responseHandler);
            // System.out.println("----------------------------------------");
//            System.out.println(responseBody);
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
