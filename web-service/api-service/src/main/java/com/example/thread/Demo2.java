/**
 * FileName: Demo2
 * Author:   13235
 * Date:     2019/3/31 21:11
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
public class Demo2 {

    private Object object = new Object();
    private Object object2 = new Object();

    public void a () {

        synchronized (object) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (object2) {
                System.out.println("a");
            }
        }
    }

    public void b() {
        synchronized (object2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        Demo2 d = new Demo2();
        new Thread(() -> {
       d.a();
        }).start();
        new Thread(() -> {
            d.b();

        }).start();


    }

}
