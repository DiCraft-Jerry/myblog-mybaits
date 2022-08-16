package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.FriendLinkDao;
import cn.dicraft.myblog.entity.FriendLink;
import cn.dicraft.myblog.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 21:22
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription: 友链业务实现层
 */
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkDao friendLinkDao;

    /**
     * 查询友链管理列表
     * @return
     */
    @Override
    @Cacheable(value = "friendlinkList",key = "'friendlink'")
    public List<FriendLink> listFriendLink() {
        return friendLinkDao.listFriendLink();
    }

    /**
     * 新增友链
     * @param friendLink
     * @return
     */
    @Override
    public int saveFriendLink(FriendLink friendLink) {
        return friendLinkDao.saveFriendLink(friendLink);
    }

    /**
     * 根据网址查询友链
     * @param blogaddress
     * @return
     */
    @Override
    public FriendLink getFriendLinkByBlogaddress(String blogaddress) {
        return friendLinkDao.getFriendLinkByBlogaddress(blogaddress);
    }

    /**
     * 根据id查询友链
     * @param id
     * @return
     */
    @Override
    public FriendLink getFriendLink(Long id) {
        return friendLinkDao.getFriendLink(id);
    }

    /**
     * 编辑修改友链
     * @param friendLink
     * @return
     */
    @Override
    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkDao.updateFriendLink(friendLink);
    }

    /**
     * 删除友链
     * @param id
     * @retuen
     */
    @Override
    public void deleteFriendLink(Long id) {
        friendLinkDao.deleteFriendLink(id);
    }
}
