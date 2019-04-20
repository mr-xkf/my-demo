/**
 * FileName: Main4
 * Author:   13235
 * Date:     2019/4/7 21:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main4 {

    public static final int TIME_OUT = 5000;
    public static void main(String[] args) {
        Socket socket = new Socket();
        InetSocketAddress hostaddress= null;
        try {
            hostaddress = "" != null ? new InetSocketAddress("", 3454) :
                    new InetSocketAddress(InetAddress.getByName(null), 2343);
            socket.setSoTimeout(TIME_OUT);
            socket.connect(hostaddress, TIME_OUT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
