/**
 * FileName: CustomListenerConfig
 * Author:   13235
 * Date:     2019/3/23 17:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.config;

import org.springframework.context.ApplicationListener;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/23
 * @since 1.0.0
 */
public class CustomListenerConfig  implements ApplicationListener<CustomMsg> {

    @Override
    public void onApplicationEvent(CustomMsg customMsg) {
        System.out.println("监听到的消息是："+customMsg.getMsg());
    }
}
