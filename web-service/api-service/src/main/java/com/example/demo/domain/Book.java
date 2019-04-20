/**
 * FileName: Book
 * Author:   13235
 * Date:     2019/3/30 18:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.domain;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/30
 * @since 1.0.0
 */
@Data
public class Book {

    private int id;

    private String name;

    private String author;

    private int year;

    private double price;




}
