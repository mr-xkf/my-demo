/**
 * FileName: NetworkUtils
 * Author:   13235
 * Date:     2019/3/30 17:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/30
 * @since 1.0.0
 */
public class NetworkUtils {

    /**
     * 请求相应url响应内容
     *
     * @param url
     * @param httpMethod
     * @return
     */
    public static String getResposes(String url, String httpMethod) throws KeyManagementException {
        String result = "";
        try {
            URL r = new URL(url);
            HttpsURLConnection urlConnection = (HttpsURLConnection) r.openConnection();
            SSLContext tls = SSLContext.getInstance("TLS");
            tls.init(null,
                    new TrustManager[]{new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }}
                    , null);
            urlConnection.setSSLSocketFactory(tls.getSocketFactory());
            urlConnection.setHostnameVerifier((s, sslSession) -> false);

            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(false);
            urlConnection.setUseCaches(false);
            if (StringUtils.isBlank(httpMethod)) {
                urlConnection.setRequestMethod("GET");
            } else {
                urlConnection.setRequestMethod(httpMethod.toUpperCase());
            }
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String input = "";
            while ((input = br.readLine()) != null) {
                result = input + "\n";
            }
            System.out.println(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
