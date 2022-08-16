package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.PictureDao;
import cn.dicraft.myblog.entity.Picture;
import cn.dicraft.myblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 9:54
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription: 照片墙业务层接口实现类
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 查询照片
     *
     * @return
     */
    @Override
    @Cacheable(value = "pictureList",key = "'picture'")      // redis缓存
    public List<Picture> listPicture() {
        return pictureDao.listPicture();
    }

    /**
     * 添加图片
     *
     * @param picture
     * @return
     */
    @Override
    public int savePicture(Picture picture) {
        return pictureDao.savePicture(picture);
    }

    /**
     * 根据id查询照片
     *
     * @param id
     * @return
     */
    @Override
    public Picture getPicture(Long id) {
        return pictureDao.getPicture(id);
    }

    /**
     * 编辑修改相册
     *
     * @param picture
     * @return
     */
    @Override
    public int updatePicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    /**
     * 删除照片
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int deletePicture(Long id) {
        int result = pictureDao.deletePicture(id);
        return result;
    }
}
