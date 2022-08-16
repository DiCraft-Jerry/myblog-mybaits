package cn.dicraft.myblog.queryVo;

import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 12:02
 * @package: cn.dicraft.myblog.queryVo
 * @Version: 1.0
 * @Decsription: 博客详情实体类
 */
@Data
public class DetailedBlog {

    /**
     * 博客信息
     */
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    /**
     * 分类名称
     */
    private String typeName;

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", commentCount=" + commentCount +
                ", updateTime=" + updateTime +
                ", commentabled=" + commentabled +
                ", shareStatement=" + shareStatement +
                ", appreciation=" + appreciation +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
