/**
 * FileName: Task
 * Author:   13235
 * Date:     2019/4/7 17:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Task implements Runnable {

    private CyclicBarrier cyclicBarrier;
    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("开始执行");
        try {
            Thread.sleep(2000);
            System.out.println("执行完毕！");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
