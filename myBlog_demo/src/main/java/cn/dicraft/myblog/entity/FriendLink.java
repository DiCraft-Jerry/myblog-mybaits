package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:26
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 友链实体类
 */
@Data
public class FriendLink {
    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;

    @Override
    public String toString() {
        return "FriendLink{" +
                "id=" + id +
                ", blogname='" + blogname + '\'' +
                ", blogaddress='" + blogaddress + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
