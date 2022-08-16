package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:23
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 分类实体类
 */
@Data
public class Type {
    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
