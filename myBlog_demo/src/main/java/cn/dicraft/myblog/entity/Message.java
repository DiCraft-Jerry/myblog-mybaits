package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:25
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 留言实体类
 */
@Data
public class Message {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long parentMessageId;
    private boolean adminMessage;

    /**
     * 回复留言
     */
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;

    private String parentEmail;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", parentMessageId=" + parentMessageId +
                ", adminMessage=" + adminMessage +
                ", replyMessages=" + replyMessages +
                ", parentMessage=" + parentMessage +
                ", parentNickname='" + parentNickname + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                '}';
    }
}
