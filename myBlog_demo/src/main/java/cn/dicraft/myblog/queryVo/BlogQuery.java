package cn.dicraft.myblog.queryVo;

import cn.dicraft.myblog.entity.Type;
import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 10:53
 * @package: cn.dicraft.myblog.queryVo
 * @Version: 1.0
 * @Decsription:
 */
@Data
public class BlogQuery {
    private Long id;
    private String title;
    private Date createTime;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;

    @Override
    public String toString() {
        return "BlogQuery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", recommend=" + recommend +
                ", published=" + published +
                ", typeId=" + typeId +
                ", type=" + type +
                '}';
    }
}
