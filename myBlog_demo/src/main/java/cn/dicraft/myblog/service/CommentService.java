package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 21:57
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 评论业务层接口
 */
@Service
public interface CommentService {
    /**
     * 根据博客id查询评论信息
     * @param blogId
     * @return
     */
    List<Comment> listCommentByBlogId(Long blogId);

    /**
     * 添加保存评论
     * @param comment
     * @param parentComment
     * @return
     */
    int saveComment(Comment comment,Comment parentComment);

    /**
     * 删除评论
     * @param comment
     * @param id
     */
    void deleteComment(Comment comment,Long id);

    /**
     * 根据父评论id查询留言信息
     * @param parentId
     * @return
     */
    Comment getEmailByParentId(Long parentId);

}
