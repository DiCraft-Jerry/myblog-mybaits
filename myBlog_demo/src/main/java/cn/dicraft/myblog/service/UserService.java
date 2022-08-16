package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 13:04
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 用户业务层接口
 */
@Service
public interface UserService {
    /**
     * 核对用户名和密码
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User checkUser(String username, String password);
}
