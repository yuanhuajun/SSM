package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author yhj
 * @version 1.0
 * @date 2023/1/15 14:14
 * @Description
 */


@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    //如果找到了多个匹配的bean，会自动转换为byName的方式进行装配
    //如果byName没有找到匹配的id，此时，可以通过  @Qualifier注解指定某个bean的id为当前属性赋值
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Override
    public void saveUser() {
        userDao.savaUser();
    }
}
