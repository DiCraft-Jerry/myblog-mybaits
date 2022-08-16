package cn.dicraft.myblog.queryVo;

import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 11:58
 * @package: cn.dicraft.myblog.queryVo
 * @Version: 1.0
 * @Decsription: 首页博客信息实体类
 */
@Data
public class FirstPageBlog {
    /**
     * 博客信息
     */
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private String description;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 用户名
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    @Override
    public String toString() {
        return "FirstPageBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", views=" + views +
                ", commentCount=" + commentCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", typeName='" + typeName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
