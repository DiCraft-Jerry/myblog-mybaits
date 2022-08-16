package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.TypeDao;
import cn.dicraft.myblog.entity.Type;
import cn.dicraft.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Service注解：用于标注业务层组件
 *
 * @Autowired注解：@Autowired表示被修饰的类需要注入对象,spring会扫描所有被@Autowired标注的类,然后根据类型在ioc容器中找到匹配的类注入
 *
 * @Transactional注解：实现事务操作 这个注解要注意将事务回滚
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 19:09
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription: 分类业务层接口实现类
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeDao.getAllTypeAndBlog();
    }

}
