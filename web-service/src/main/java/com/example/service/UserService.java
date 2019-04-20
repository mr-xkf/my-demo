/**
 * FileName: UserService
 * Author:   13235
 * Date:     2019/3/16 19:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.service;

import com.example.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/3/16
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /***
     *
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void update(User user);

    /***
     * 根据主键删除用户信息
     * @param id
     *
     */
    void deleteUser(Integer id);

    /**
     * 根据条件查询用户信息
     *
     * @param map
     * @return
     */
    List<User> findByUserCondition(Map<String, Object> map);
}
