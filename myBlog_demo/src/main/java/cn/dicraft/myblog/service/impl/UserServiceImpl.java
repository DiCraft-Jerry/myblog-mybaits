package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.UserDao;
import cn.dicraft.myblog.entity.User;
import cn.dicraft.myblog.service.UserService;
import cn.dicraft.myblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 13:05
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription: 用户业务层接口实现类
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
