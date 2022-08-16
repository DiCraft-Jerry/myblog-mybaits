package cn.dicraft.myblog.queryVo;

import lombok.Data;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 12:06
 * @package: cn.dicraft.myblog.queryVo
 * @Version: 1.0
 * @Decsription:
 */
@Data
public class SearchBlog {

    private String title;
    private Long typeId;

    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
