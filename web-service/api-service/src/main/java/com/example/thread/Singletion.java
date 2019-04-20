/**
 * FileName: Singletion
 * Author:   13235
 * Date:     2019/3/31 20:37
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
public class Singletion {
    private Singletion(){}

    private static Singletion singletion = new Singletion();

    public static Singletion getIntance() {
        return singletion;
    }

}
