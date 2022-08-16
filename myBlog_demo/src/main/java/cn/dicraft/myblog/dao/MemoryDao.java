package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Memory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 23:06
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 流年记持久层接口
 */
@Mapper
@Repository
public interface MemoryDao {
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
