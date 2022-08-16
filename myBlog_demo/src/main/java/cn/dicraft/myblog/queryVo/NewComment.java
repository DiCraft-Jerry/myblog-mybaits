package cn.dicraft.myblog.queryVo;

import lombok.Data;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 12:03
 * @package: cn.dicraft.myblog.queryVo
 * @Version: 1.0
 * @Decsription: 最新评论实体类
 */
@Data
public class NewComment {

    private Long id;
    private Long blogId;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "NewComment{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
