/**
 * FileName: Main2
 * Author:   13235
 * Date:     2019/4/7 17:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Main2 {


    public static void main(String[] args) {
         CyclicBarrier cb = new CyclicBarrier(12,
                () -> {
                    System.out.println("开始集合了！");
                });

        Task task = new Task(cb);
        for (int i = 0; i < 12; i++) {
            new Thread(task).start();
        }


    }

}
