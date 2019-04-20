/**
 * FileName: DruidStatViewServlet
 * Author:   13235
 * Date:     2019/3/16 19:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/16
 * @since 1.0.0
 */
@WebServlet(urlPatterns = {"/druid/*"},
initParams = {@WebInitParam(name="loginUsername",value="admin"),
   @WebInitParam(name="loginPassword",value="admin"),@WebInitParam(name="restEnable",value="false")})
public class DruidStatViewServlet extends StatViewServlet {
}
