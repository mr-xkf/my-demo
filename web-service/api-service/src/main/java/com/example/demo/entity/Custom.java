/**
 * FileName: Custom
 * Author:   13235
 * Date:     2019/3/25 23:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/25
 * @since 1.0.0
 */
@Entity
@Table(name="person")
@Data
@NamedStoredProcedureQueries(value = {@NamedStoredProcedureQuery(name = "sp_test",procedureName = "sp_test",parameters = {
        @StoredProcedureParameter(name="str",mode = ParameterMode.OUT,type=String.class)
})})
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = true,unique = true)
    private Integer id;

    @Column(name="age")
    private Integer age;
    @Column(name="address")
    private String address;
    @Column(name="name")
    private String name;

}
