package cn.dicraft.myblog.service;

import cn.dicraft.myblog.entity.Memory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 9:41
 * @package: cn.dicraft.myblog.service
 * @Version: 1.0
 * @Decsription: 流年记业务层接口
 */
@Service
public interface MemoryService {
    /**
     * 查询流年记
     * @return
     */
    List<Memory> listMemory();

    /**
     * 保存流年记
     * @param memory
     * @return
     */
    int saveMemory(Memory memory);

    /**
     * 查找id
     * @param id
     * @return
     */
    Memory getMemory(Long id);

    /**
     * 修改流年记
     * @param memory
     * @return
     */
    int updateMemory(Memory memory);

    /**
     * 删除流年记
     * @param id
     */
    void deleteMemory(Long id);
}
