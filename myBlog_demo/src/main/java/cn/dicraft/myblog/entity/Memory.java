package cn.dicraft.myblog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: DiCraft
 * @Date: 2022-08-13 18:33
 * @package: cn.dicraft.myblog.entity
 * @Version: 1.0
 * @Decsription: 流年记实体类
 */
@Data
public class Memory {
    private Long id;
    private Date createTime;
    private String pictureAddress;
    private String memory;

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
