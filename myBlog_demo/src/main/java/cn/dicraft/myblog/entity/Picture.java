package cn.dicraft.myblog.entity;

import lombok.Data;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:27
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 相册实体类
 */

@Data
public class Picture {
    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", picturename='" + picturename + '\'' +
                ", picturetime='" + picturetime + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", picturedescription='" + picturedescription + '\'' +
                '}';
    }
}
