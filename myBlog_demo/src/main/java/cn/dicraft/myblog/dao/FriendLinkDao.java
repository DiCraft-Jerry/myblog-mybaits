package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * listFriendLink：查询出友链管理列表
 * saveFriendLink：友链新增
 * getFriendLinkByBlogaddress：在新增友链的时候做重复判断，查询到有相同友链给出提示
 * getFriendLink：编辑修改友链时查询出数据信息并显示在前端页面上
 * deleteFriendLink：删除友链
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-14 20:34
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 友链持久层
 */
@Mapper
@Repository
public interface FriendLinkDao {

    /**
     * 查询友链管理列表
     * @return
     */
    List<FriendLink> listFriendLink();

    /**
     * 新增友链
     * @param friendLink
     * @return
     */
    int saveFriendLink(FriendLink friendLink);

    /**
     * 根据网址查询友链
     * @param blogaddress
     * @return
     */
    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    /**
     * 根据id查询友链
     * @param id
     * @return
     */
    FriendLink getFriendLink(Long id);

    /**
     * 编辑修改友链
     * @param friendLink
     * @return
     */
    int updateFriendLink(FriendLink friendLink);

    /**
     * 删除友链
     * @param id
     * @retuen
     */
    void deleteFriendLink(Long id);
}
