package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 12:35
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 用户实体类
 */
@Data
public class User {
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
