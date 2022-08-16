package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 23:07
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription:
 */
@Mapper
@Repository
public interface MessageDao {


    /**
     * 添加一个评论
     * @param message
     * @return
     */
    int saveMessage(Message message);

    /**
     * 查询父级评论
     * @param ParentId
     * @return
     */
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);

    /**
     * 查询一级回复
     * @param id
     * @return
     */
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    /**
     * 查询二级以及所有子集回复
     * @param childId
     * @return
     */
    List<Message> findByReplayId(@Param("childId") Long childId);

    /**删除评论
     * @param id
     */
    void deleteMessage(Long id);

    /**
     * 根据父评论id查询留言信息
     * @param parentId
     * @return
     */
    Message getEmailByParentId(Long parentId);
}
