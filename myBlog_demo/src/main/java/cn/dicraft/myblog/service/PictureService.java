package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.Picture;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 9:41
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 照片墙业务层接口
 */
@Service
public interface PictureService {
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
