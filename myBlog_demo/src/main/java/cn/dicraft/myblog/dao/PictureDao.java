package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 23:08
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription:
 */
@Mapper
@Repository
public interface PictureDao {

    /**
     * 查询照片
     * @return
     */
    List<Picture> listPicture();

    /**
     * 添加图片
     * @param picture
     * @return
     */
    int savePicture(Picture picture);

    /**
     * 根据id查询照片
     * @param id
     * @return
     */
    Picture getPicture(Long id);

    /**
     * 编辑修改相册
     * @param picture
     * @return
     */
    int updatePicture(Picture picture);

    /**
     * 删除照片
     * @param id
     * @return
     */
    int deletePicture(Long id);

}
