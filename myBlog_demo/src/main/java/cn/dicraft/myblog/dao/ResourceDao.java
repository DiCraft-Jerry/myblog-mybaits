package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 23:08
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 资源库持久层接口
 */
@Mapper
@Repository
public interface ResourceDao {


    /**
     * 新增资源
     * @param resources
     * @return
     */
    int saveResource(Resources resources);

    /**
     * 查询资源列表
     * @return
     */
    List<Resources> listResources();

    /**
     * 根据ID查询资源
     * @param id
     * @return
     */
    Resources getResource(Long id);

    /**
     * 编辑资源
     * @param resources
     * @return
     */
    int updateResource(Resources resources);

    /**
     * 根据ID删除资源
     * @param id
     */
    void deleteResource(Long id);

    /**
     * 是否发布
     * @param id
     */
    void is_published(Long id);

    /**
     * 改变发布状态
     * @param published
     * @param id
     * @return
     */
    int changePublished(@Param("published") boolean published, @Param("id") Long id);

    /**
     * 查询学习资源
     * @param studyResource
     * @return
     */
    List<Resources> getStudyResource(String studyResource);

    /**
     * 查询图片资源
     * @param pictureResource
     * @return
     */
    List<Resources> getPictureResource(String pictureResource);

    /**
     * 查询办公资源
     * @param officeResource
     * @return
     */
    List<Resources> getOfficeResource(String officeResource);

    /**
     * 查询娱乐资源
     * @param recrearionResource
     * @return
     */
    List<Resources> getRecreationResource(String recrearionResource);

    /**
     * 查询设计资源
     * @param desognResource
     * @return
     */
    List<Resources> getDesignResource(String desognResource);

    /**
     * 查询搜索资源
     * @param searchResource
     * @return
     */
    List<Resources> getSearchResource(String searchResource);

    /**
     * 查询工具资源
     * @param toolResource
     * @return
     */
    List<Resources> getToolResource(String toolResource);

    Integer getStudyResourceTotle(String studyResource);

    Integer getPictureResourceTotle(String pictureResource);

    Integer getOfficeResourceTotle(String officeResource);

    Integer getRecreationResourceTotle(String recreationResource);

    Integer getDesignResourceTotle(String designResource);

    Integer getSearchResourceTotle(String searchResource);

    Integer getToolResourceTotle(String toolResource);
}
