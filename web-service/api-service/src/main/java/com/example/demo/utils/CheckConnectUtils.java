/**
 * FileName: CheckConnectUtils
 * Author:   13235
 * Date:     2019/3/28 0:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/28
 * @since 1.0.0
 */
public class CheckConnectUtils {

    //公众号平台配置的token
    private static final String token = "xkftestwx";
    public static final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    /**
     * 判断是否链接匹配
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkConnectWithWechat(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        //排序
        Arrays.sort(arr);
        //生成字符串
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        //进行sha1加密
        String encodeString = passSha1Encode(sb.toString());
        if (signature.equals(encodeString)) {
            return true;
        }
        return false;
    }

    /**
     * 进行字符串SHA1加密
     *
     * @param string
     * @return
     */
    public static String passSha1Encode(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            sha1.update(string.getBytes(Charset.forName("utf-8")));
            byte[] digest = sha1.digest();
            int j = digest.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = digest[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
