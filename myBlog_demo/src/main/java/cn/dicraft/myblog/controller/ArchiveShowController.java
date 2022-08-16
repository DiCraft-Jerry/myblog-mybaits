package cn.dicraft.myblog.controller;

import cn.dicraft.myblog.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:06
 * @package: cn.dicraft.myblog.contoller
 * @Version: 1.0
 * @Decsription: 时间轴页面显示控制器
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping("/archives")
    public String archive(Model model){
        model.addAttribute("memorys",  memoryService.listMemory());
        return "archives";
    }
}
