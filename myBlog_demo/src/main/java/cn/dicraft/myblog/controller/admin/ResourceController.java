package cn.dicraft.myblog.controller.admin;

import cn.dicraft.myblog.entity.Resources;
import cn.dicraft.myblog.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 22:48
 * @package: cn.dicraft.myblog.contoller.admin
 * @Version: 1.0
 * @Decsription: 资源后台管理控制器
 */
@Controller
@RequestMapping("/admin")
public class ResourceController {
    boolean flage;

    @Autowired
    private ResourceService resourceService;


    /**
     * 查询照片列表
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/resources")
    public String pictures(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Resources> listResources = resourceService.listResources();
        PageInfo<Resources> pageInfo = new PageInfo<Resources>(listResources);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/resources";
    }

    /**
     * 跳转新增页面
     * @param model
     * @return
     */
    @GetMapping("/resources/input")
    public String input(Model model) {
        model.addAttribute("resource", new Resources());
        return "admin/resources-input";
    }


    /**
     * 资源新增
     * @param resources
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping("/resources")
    public String post(@Valid Resources resources, BindingResult result, RedirectAttributes attributes){
        resources.setPublished(true);
        if(result.hasErrors()){
            return "admin/resources-input";
        }

        int P = resourceService.saveResource(resources);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/resources";
    }

    /**
     * 跳转照片编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/resources/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("resource", resourceService.getResource(id));
        return "admin/resources-input";
    }

    /**
     * 编辑相册
     * @param resources
     * @param attributes
     * @return
     */
    @PostMapping("/resources/{id}")
    public String editPost(@Valid Resources resources, RedirectAttributes attributes) {

        int P = resourceService.updateResource(resources);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/resources";
    }

    /**
     * 删除资源
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/resources/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        resourceService.deleteResource(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/resources";
    }

    /**
     * @description 发布资源
     * @author Dicraft
     * @date 2022-08-14 22:48
     * @param id
     * @param attributes
     * @throws
     * @return java.lang.String
     */
    @GetMapping("/resources/{id}/public")
    public String is_published(@PathVariable Long id, RedirectAttributes attributes){

        Resources resources = resourceService.getResource(id);

        flage = resources.isPublished();
        if(!flage){
            resourceService.changePublished(true,id);
            attributes.addFlashAttribute("message", "成功发布");
            flage = !flage;
        }else{
            resourceService.changePublished(false,id);
            attributes.addFlashAttribute("message", "取消发布");
            flage = !flage;
        }

        return "redirect:/admin/resources";
    }


}
