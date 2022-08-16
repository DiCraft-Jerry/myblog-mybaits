package cn.dicraft.myblog.controller;

import cn.dicraft.myblog.annotation.AccessLimit;
import cn.dicraft.myblog.entity.Comment;
import cn.dicraft.myblog.entity.User;
import cn.dicraft.myblog.queryVo.DetailedBlog;
import cn.dicraft.myblog.service.BlogService;
import cn.dicraft.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:06
 * @package: cn.dicraft.myblog.contoller
 * @Version: 1.0
 * @Decsription: 评论控制器
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    /**
     * 查询评论列表
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    /**
     * 新增评论
     * @param comment
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/comments")
    @AccessLimit(seconds = 15, maxCount = 3) //15秒内 允许请求3次
    public String post(Comment comment, HttpSession session, Model model) {
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }
        Long parentId = comment.getParentComment().getId();
        Comment parentComment = null;
        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(parentId);

            // 根据父评论id查询留言信息
            parentComment = commentService.getEmailByParentId(parentId);
        }
        commentService.saveComment(comment,parentComment);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    /**
     * 删除评论
     * @param blogId
     * @param id
     * @param comment
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id, Comment comment, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user != null) {
            commentService.deleteComment(comment,id);
        }
        DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "blog";
    }
}
