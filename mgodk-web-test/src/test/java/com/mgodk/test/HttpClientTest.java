package com.mgodk.test;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HttpClientTest
 * @Description 伪浏览器请求
 * @Author WJJ
 * @Date 2020/10/27 15:39
 * @Version 1.0
 */
public class HttpClientTest {
    @Test
    public void test() throws Exception {
        testDoGet();
        testDoPost();
        testDoPoolManager();
    }

    public void testDoGet() throws IOException {
        //创建 Httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //1】创建 Http Get 请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");
        //2】创建 Http Get 请求，通过 URI
        //URI uri =
        //HttpGet httpGet = new HttpGet(uri);

        //构建请求配置信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(100) //创建连接最长时间
                .setConnectionRequestTimeout(500) //从连接池中获取连接的最长时间
                .setSocketTimeout(10 * 1000) //数据传输的最长时间
                .setStaleConnectionCheckEnabled(true) //提交前测试连接是否可用
                .build();
        //设置请求配置信息
        httpGet.setConfig(config);

        CloseableHttpResponse response = null;
        try {
            //执行请求
            response = httpClient.execute(httpGet);
            //判断返回状态
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(),"UTF-8");
                System.out.println("内容：" + content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
    }

    public void testDoPost() throws IOException {
        //创建 Httpclient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建 Http POST 请求
        HttpPost httpPost = new HttpPost("http://www.");
        //伪装成浏览器
        httpPost.setHeader("User-Agent","");

        //设置参数
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("",""));
        //构造一个 form 表单实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        //请求实体添加到请求中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            //执行请求
            response = httpClient.execute(httpPost);
            //判断返回状态
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }

    }

    public void testDoPoolManager() throws IOException {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        manager.setMaxTotal(200);
        //设置每个主机地址并发数
        manager.setDefaultMaxPerRoute(20);
        toGet(manager);
    }
    public void toGet(PoolingHttpClientConnectionManager manager) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(manager).build();
        //创建 Http Get 请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");

        CloseableHttpResponse response = null;
        try {
            //执行请求
            response = httpClient.execute(httpGet);
            //判断返回状态
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(),"UTF-8");
                System.out.println("内容：" + content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            //此时不能关闭 httpClient,如果关闭，连接池会销毁
            //httpClient.close();
        }
    }
}
