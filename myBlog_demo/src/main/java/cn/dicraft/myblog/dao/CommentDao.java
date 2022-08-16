package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 21:48
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 评论持久层接口
 */
@Mapper
@Repository
public interface CommentDao {

    /**
     * 查询父级评论
     * @param blogId
     * @param blogParentId
     * @return
     */
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    /**
     * 查询一级回复
     * @param blogId
     * @param id
     * @return
     */
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);

    /**
     * 查询二级回复
     * @param blogId
     * @param childId
     * @return
     */
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId,@Param("childId") Long childId);

    /**
     * 添加一个评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment);

    /**
     * 删除评论
     * @param id
     */
    void deleteComment(Long id);

    /**
     * 根据父评论id查询留言信息
     * @param parentId
     * @return
     */
    Comment getEmailByParentId(Long parentId);

}
