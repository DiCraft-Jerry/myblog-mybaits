package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:28
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 资源库实体类
 */

@Data
public class Resources {
    private Long id;
    private String resourceName;
    private String firstType;
    private String secondType;
    private String pictureAddress;
    private String resourceAddress;
    private String resourceDescription;
    private Date createTime;
    private Integer sort;
    private boolean published;

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", firstType='" + firstType + '\'' +
                ", secondType='" + secondType + '\'' +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", resourceAddress='" + resourceAddress + '\'' +
                ", resourceDescription='" + resourceDescription + '\'' +
                ", createTime=" + createTime +
                ", sort=" + sort +
                ", published=" + published +
                '}';
    }
}
