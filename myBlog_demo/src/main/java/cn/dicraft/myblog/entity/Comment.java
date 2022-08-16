package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:24
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 评论实体类
 */
@Data
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long blogId;
    private Long parentCommentId;
    private boolean adminComment;

    /**
     * 回复评论
     */
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private String parentNickname;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blogId=" + blogId +
                ", parentCommentId=" + parentCommentId +
                ", adminComment=" + adminComment +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", parentNickname='" + parentNickname + '\'' +
                '}';
    }
}
