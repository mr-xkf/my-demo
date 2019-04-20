/**
 * FileName: CustomMsg
 * Author:   13235
 * Date:     2019/3/23 17:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.config;

import org.springframework.context.ApplicationEvent;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/23
 * @since 1.0.0
 */
public class CustomMsg extends ApplicationEvent {

    private String msg;
    public CustomMsg(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    public String sendMsg(String msg) {
        this.msg = msg;
        return "发送的消息是：" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
