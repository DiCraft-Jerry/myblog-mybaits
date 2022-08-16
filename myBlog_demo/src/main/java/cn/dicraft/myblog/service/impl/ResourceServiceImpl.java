package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.ResourceDao;
import cn.dicraft.myblog.entity.Resources;
import cn.dicraft.myblog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 9:54
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription: 资源库业务层接口实现类
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    /**
     * 新增资源
     * @param resources
     * @return
     */
    @Override
    public int saveResource(Resources resources) {
        return resourceDao.saveResource(resources);
    }

    /**
     * 查询资源列表
     *
     * @return
     */
    @Override
    public List<Resources> listResources() {
        return resourceDao.listResources();
    }

    /**
     * 根据ID查询资源
     *
     * @param id
     * @return
     */
    @Override
    public Resources getResource(Long id) {
        return resourceDao.getResource(id);
    }

    /**
     * 编辑资源
     *
     * @param resources
     * @return
     */
    @Override
    public int updateResource(Resources resources) {
        return resourceDao.updateResource(resources);
    }

    /**
     * 根据ID删除资源
     *
     * @param id
     */
    @Override
    public void deleteResource(Long id) {
        resourceDao.deleteResource(id);
    }

    /**
     * 是否发布
     *
     * @param id
     */
    @Override
    public void is_published(Long id) {
        resourceDao.is_published(id);
    }

    /**
     * 改变发布状态
     *
     * @param flage
     * @param id
     * @return
     */
    @Override
    public int changePublished(boolean flage, Long id) {
        return resourceDao.changePublished(flage,id);
    }

    /**
     * 查询学习资源
     *
     * @param studyResource
     * @return
     */
    @Override
//    @Cacheable(value = "studyResource",key = "'studyResourceList'")      // redis缓存
    public List<Resources> getStudyResource(String studyResource) {
        return resourceDao.getStudyResource(studyResource);
    }

    /**
     * 查询图片资源
     *
     * @param pictureResource
     * @return
     */
    @Override
    @Cacheable(value = "pictureResource",key = "'pictureResourceList'")      // redis缓存
    public List<Resources> getPictureResource(String pictureResource) {
        return resourceDao.getPictureResource(pictureResource);
    }

    /**
     * 查询办公资源
     *
     * @param officeResource
     * @return
     */
    @Override
    @Cacheable(value = "officeResource",key = "'officeResourceList'")      // redis缓存
    public List<Resources> getOfficeResource(String officeResource) {
        return resourceDao.getOfficeResource(officeResource);
    }

    /**
     * 查询娱乐资源
     *
     * @param recreationResource
     * @return
     */
    @Override
    @Cacheable(value = "recreationResource",key = "'recreationResourceList'")      // redis缓存
    public List<Resources> getRecreationResource(String recreationResource) {
        return resourceDao.getRecreationResource(recreationResource);
    }

    /**
     * 查询设计资源
     *
     * @param designResource
     * @return
     */
    @Override
//    @Cacheable(value = "designResource",key = "'designResourceList'")      // redis缓存
    public List<Resources> getDesignResource(String designResource) {
        return resourceDao.getDesignResource(designResource);
    }

    /**
     * 查询搜索资源
     *
     * @param searchResource
     * @return
     */
    @Override
//    @Cacheable(value = "searchResource",key = "'searchResourceList'")      // redis缓存
    public List<Resources> getSearchResource(String searchResource) {
        return resourceDao.getSearchResource(searchResource);
    }

    /**
     * 查询工具资源
     *
     * @param toolResource
     * @return
     */
    @Override
//    @Cacheable(value = "toolResource",key = "'toolResourceList'")      // redis缓存
    public List<Resources> getToolResource(String toolResource) {
        return resourceDao.getToolResource(toolResource);
    }

    @Override
    public Integer getStudyResourceTotle(String studyResource) {
        return resourceDao.getStudyResourceTotle(studyResource);
    }

    @Override
    public Integer getPictureResourceTotle(String pictureResource) {
        return resourceDao.getPictureResourceTotle(pictureResource);
    }

    @Override
    public Integer getOfficeResourceTotle(String officeResource) {
        return resourceDao.getOfficeResourceTotle(officeResource);
    }

    @Override
    public Integer getRecreationResourceTotle(String recreationResource) {
        return resourceDao.getRecreationResourceTotle(recreationResource);
    }

    @Override
    public Integer getDesignResourceTotle(String designResource) {
        return resourceDao.getDesignResourceTotle(designResource);
    }

    @Override
    public Integer getSearchResourceTotle(String searchResource) {
        return resourceDao.getSearchResourceTotle(searchResource);
    }

    @Override
    public Integer getToolResourceTotle(String toolResource) {
        return resourceDao.getToolResourceTotle(toolResource);
    }
}
