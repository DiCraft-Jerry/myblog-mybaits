package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.FriendLink;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 21:13
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 友链业务层
 */
@Service
public interface FriendLinkService {

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
