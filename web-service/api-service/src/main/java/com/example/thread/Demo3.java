/**
 * FileName: Demo3
 * Author:   13235
 * Date:     2019/4/7 18:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/4/7
 * @since 1.0.0
 */
public class Demo3 extends RecursiveTask<Integer> {

    private Integer start;

    private Integer end;

    public Demo3(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        Integer sum=0;
        if (end - start <= 10) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else{
            Demo3 d1 = new Demo3(start, (start+end) / 2);
            Demo3 d2 = new Demo3((end + start) / 2 + 1, end);
            d1.fork();
            d2.fork();
            Integer join = d1.join();
            Integer join2 = d2.join();
            sum=join + join2;

        }
        return sum;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3(1, 100);
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ForkJoinTask<Integer> submit = pool.submit(demo3);
        System.out.println(".....");
        try {
            System.out.println("结果是:" + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
