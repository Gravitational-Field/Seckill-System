package org.lzj.miaosha.service;

import org.lzj.miaosha.dao.UserDao;
import org.lzj.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/24 20:30
 * @Version 1.0
 **/

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }

    @Transactional
    public boolean tx() {
        User user1 = new User();
        user1.setId(3);
        user1.setName("3333");
        userDao.insert(user1);


        User user2 = new User();
        user2.setId(2);
        user2.setName("2222");
        userDao.insert(user2);

        return true;
    }

}
