/**
 * FileName: Main
 * Author:   13235
 * Date:     2019/3/31 20:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/31
 * @since 1.0.0
 */
public class Main {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        for (int i = 0; i < 40; i++) {
            executorService.execute(()->{

                Singletion2 instance = Singletion2.getInstance();
                System.out.println(Thread.currentThread().getName()+":"+instance);
            });
        }
    }
}
