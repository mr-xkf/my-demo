/**
 * FileName: WechatController
 * Author:   13235
 * Date:     2019/3/27 22:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.controller;

import com.example.demo.utils.CheckConnectUtils;
import com.example.demo.utils.ClientCustomSSL;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/27
 * @since 1.0.0
 */
@RestController
@Slf4j
public class WechatController {

    @RequestMapping("/test")
    public String testParam(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.info(" {},@{},${},^", signature, timestamp, nonce, echostr);
        if (CheckConnectUtils.checkConnectWithWechat(signature, timestamp, nonce)) {
            return echostr;
        }
        return "验证失败！";
    }

    public static void main(String[] args) {
        String appId = "wx159067bdddf98d81";
        String appSecret = "781708b7a9df4757bd50a619ad0d245a";
        String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);
            //String resposes = NetworkUtils.getResposes(Url, "");
        String resposes = ClientCustomSSL.httpGet(Url);
        System.out.println(resposes);
           Object access_token = JSONObject.fromObject(resposes).get("access_token");
            System.out.println(access_token.toString());

    }
}
