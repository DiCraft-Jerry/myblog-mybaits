package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 19:05
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 分类业务层接口
 */
@Service
public interface TypeService {
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
     * @retuen
     */
    void deleteType(Long id);


    /**
     * 查询所有分类
     * @return
     */
    List<Type>getAllTypeAndBlog();
}
