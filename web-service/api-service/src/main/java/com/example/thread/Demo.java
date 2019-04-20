/**
 * FileName: Demo
 * Author:   13235
 * Date:     2019/3/31 20:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/31
 * @since 1.0.0
 */
public class Demo {

    public synchronized void a() {
        System.out.println("a");
        b();
    }

    public synchronized void b() {
        System.out.println("b");
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(() -> {
            d.a();

        }).start();
        new Thread(() -> {
            d.b();

        }).start();
    }

}
