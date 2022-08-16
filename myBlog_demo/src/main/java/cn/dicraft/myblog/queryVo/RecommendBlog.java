package cn.dicraft.myblog.queryVo;

import lombok.Data;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 12:01
 * @package: cn.dicraft.myblog.queryVo
 * @Version: 1.0
 * @Decsription: 推荐博客数据实体类
 */
@Data
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;

    @Override
    public String toString() {
        return "RecommendBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
