/**
 * FileName: DruidStatFilter
 * Author:   13235
 * Date:     2019/3/16 19:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/16
 * @since 1.0.0
 */
@WebFilter(urlPatterns = {"/xkf/*"},
  initParams = {@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")})
public class DruidStatFilter extends WebStatFilter {
}
