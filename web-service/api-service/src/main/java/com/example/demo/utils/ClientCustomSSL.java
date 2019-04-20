/**
 * FileName: ClientCustomSSL
 * Author:   13235
 * Date:     2019/3/28 1:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/28
 * @since 1.0.0
 */
public class ClientCustomSSL {

    public static String httpGet(String url) {
        String s = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            SSLContext sslContext = SSLContexts.createSystemDefault();
            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"},
                    null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            HttpClients.custom().setSSLSocketFactory(factory).build();
            httpClient = HttpClients.custom().setSSLSocketFactory(factory).build();
            HttpGet get = new HttpGet(url);
            response= httpClient.execute(get);
                HttpEntity entity = response.getEntity();
                int statusLine = response.getStatusLine().getStatusCode();
                if (statusLine == HttpStatus.SC_OK) {
                    s= EntityUtils.toString(entity);
                    System.out.println(s);
                    EntityUtils.consume(entity);
                }
                return s;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();

                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }


}
