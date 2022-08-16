package cn.dicraft.myblog.controller.admin;

import cn.dicraft.myblog.entity.Memory;
import cn.dicraft.myblog.service.MemoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 22:48
 * @package: cn.dicraft.myblog.contoller.admin
 * @Version: 1.0
 * @Decsription: 流年记后台控制器
 */
@Controller
@RequestMapping("/admin")
public class MemoryController {
    @Autowired
    private MemoryService memoryService;

    /**
     * 查询流年记列表
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/memorys")
    public String pictures(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Memory> listMemory = memoryService.listMemory();
        PageInfo<Memory> pageInfo = new PageInfo<Memory>(listMemory);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/memorys";
    }

    /**
     * 跳转新增页面
     * @param model
     * @return
     */
    @GetMapping("/memorys/input")
    public String input(Model model) {
        model.addAttribute("memory", new Memory());
        return "admin/memorys-input";
    }

    /**
     * 流年记新增
     * @param memory
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping("/memorys")
    public String post(@Valid Memory memory, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            return "admin/memorys-input";
        }

        memory.setCreateTime(new Date());
        int P = memoryService.saveMemory(memory);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/memorys";
    }

    /**
     * 跳转流年编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/memorys/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("memory", memoryService.getMemory(id));
        return "admin/memorys-input";
    }

    /**
     * 编辑流年
     * @param memory
     * @param attributes
     * @return
     */
    @PostMapping("/memorys/{id}")
    public String editPost(@Valid Memory memory, RedirectAttributes attributes) {

        int P = memoryService.updateMemory(memory);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/memorys";
    }

    /**
     * 删除记忆
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/memorys/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        memoryService.deleteMemory(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/memorys";
    }
}
