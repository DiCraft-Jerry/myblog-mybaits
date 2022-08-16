package cn.dicraft.myblog.service.impl;

import cn.dicraft.myblog.dao.MemoryDao;
import cn.dicraft.myblog.entity.Memory;
import cn.dicraft.myblog.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 9:53
 * @package: cn.dicraft.myblog.service.impl
 * @Version: 1.0
 * @Decsription:
 */
@Service
public class MemoryServiceImpl implements MemoryService {

    @Autowired
    private MemoryDao memoryDao;
    /**
     * 查询流年记
     *
     * @return
     */
    @Override
    @Cacheable(value = "memoryList",key = "'memory'")       // redis缓存
    public List<Memory> listMemory() {
        return memoryDao.listMemory();
    }

    /**
     * 保存流年记
     *
     * @param memory
     * @return
     */
    @Override
    public int saveMemory(Memory memory) {
        return memoryDao.saveMemory(memory);
    }

    /**
     * 查找id
     *
     * @param id
     * @return
     */
    @Override
    public Memory getMemory(Long id) {
        return memoryDao.getMemory(id);
    }

    /**
     * 修改流年记
     *
     * @param memory
     * @return
     */
    @Override
    public int updateMemory(Memory memory) {
        return memoryDao.updateMemory(memory);
    }

    /**
     * 删除流年记
     *
     * @param id
     */
    @Override
    public void deleteMemory(Long id) {
        memoryDao.deleteMemory(id);
    }
}
