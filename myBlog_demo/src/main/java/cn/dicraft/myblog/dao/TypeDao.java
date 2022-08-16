package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:36
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 分类持久层接口
 */
@Mapper
@Repository
public interface TypeDao {

    /**
     * 新增保存分类
     * @param type
     * @return
     */
    int saveType(Type type);

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 查询所有分类
     * @return
     */
    List<Type> getAllType();

    /**
     * 根据分类名称查询分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 编辑修改分类
     * @param type
     * @return
     */
    int updateType(Type type);

    /**
     * 删除分类
     * @param id
     */
    void deleteType(Long id);

    /**
     * 查询所有分类
     * @return
     */
    List<Type> getAllTypeAndBlog();
}
