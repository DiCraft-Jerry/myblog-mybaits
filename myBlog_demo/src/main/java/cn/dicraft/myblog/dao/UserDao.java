package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Mapper注解：让Mybatis找到对应的mapper，在编译的时候动态生成代理类，实现相应SQL功能
 * @Repository注解：用来声明dao层的bean（这个注解可有可无，可以消去依赖注入的报错信息）【@Mapper和@Repository注解可以参考这篇文章：Mybatis 中的 @Repository 与 @Mapper】
 * @Param注解：将参数传递给SQL
 * 返回一个User对象给service调用并核对用户名和密码
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 12:46
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 用户持久层接口
 */

@Mapper
@Repository
public interface UserDao {
    /**
     * @Description:
     * @Auther: DiCraft
     * @Date: 2022-08-13 12:46
     * @Param: username:用户名；password:密码
     * @Return: 返回用户对象
     */

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
