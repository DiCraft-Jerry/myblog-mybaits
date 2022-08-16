package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 9:41
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 留言业务层接口
 */
@Service
public interface MessageService {


    /**
     * 查询留言列表
     * @return
     */
    List<Message> listMessage();

    /**
     * 添加一个评论
     * @param message
     * @param parentMessage
     * @return
     */
    int saveMessage(Message message,Message parentMessage);

    /**删除评论
     * @param id
     */
    void deleteMessage(Long id);

    /**
     * 根据父评论id查询留言信息
     * @param parentId
     * @return
     */
    Message getEmailByParentId(Long parentId);
}
