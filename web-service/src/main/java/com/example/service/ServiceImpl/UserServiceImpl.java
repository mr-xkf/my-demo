/**
 * FileName: UserServiceImpl
 * Author:   13235
 * Date:     2019/3/16 19:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.service.ServiceImpl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(User user) {



    }

    @Override
    public void update(User user) {




    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public List<User> findByUserCondition(Map<String, Object> map) {



        return null;
    }


}
