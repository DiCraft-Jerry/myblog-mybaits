package cn.dicraft.myblog.controller;

import cn.dicraft.myblog.annotation.AccessLimit;
import cn.dicraft.myblog.entity.Resources;
import cn.dicraft.myblog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:53
 * @package: cn.dicraft.myblog.contoller
 * @Version: 1.0
 * @Decsription: 资源显示页面控制器
 */
@Controller
public class ResourceShowController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resources")
    public String resources(Model model){

        // 因为这里就这几种资源，所以写死了，有需要的可以加一个资源分类表
        String studyResource = "学习资源";
        String pictureResource = "图片资源";
        String officeResource = "办公资源";
        String recreationResource = "娱乐资源";
        String designResource = "设计资源";
        String searchResource = "搜索资源";
        String toolResource = "工具资源";

        System.out.println( resourceService.getStudyResource(studyResource));

        model.addAttribute("studyresource", resourceService.getStudyResource(studyResource));
        model.addAttribute("pictureresource",resourceService.getPictureResource(pictureResource));
        model.addAttribute("officeresource",resourceService.getOfficeResource(officeResource));
        model.addAttribute("recreationresource",resourceService.getRecreationResource(recreationResource));
        model.addAttribute("designresource",resourceService.getDesignResource(designResource));
        model.addAttribute("searchresource",resourceService.getSearchResource(searchResource));
        model.addAttribute("toolresource",resourceService.getToolResource(toolResource));

        model.addAttribute("studyResourceTotle",resourceService.getStudyResourceTotle(studyResource));
        model.addAttribute("pictureResourceTotle",resourceService.getPictureResourceTotle(pictureResource));
        model.addAttribute("officeResourceTotle",resourceService.getOfficeResourceTotle(officeResource));
        model.addAttribute("recreationResourceTotle",resourceService.getRecreationResourceTotle(recreationResource));
        model.addAttribute("designResourceTotle",resourceService.getDesignResourceTotle(designResource));
        model.addAttribute("searchResourceTotle",resourceService.getSearchResourceTotle(searchResource));
        model.addAttribute("toolResourceTotle",resourceService.getToolResourceTotle(toolResource));


        return "resources";
    }

    /**
     * 资源新增
     * @param resources
     * @param result
     * @param attributes
     * @return
     */
    @AccessLimit(seconds = 15, maxCount = 3) //15秒内 允许请求3次
    @PostMapping("/resources")
    public String post(@Valid Resources resources, BindingResult result, RedirectAttributes attributes){
        resources.setPublished(false);
        if(result.hasErrors()){
            return "admin/resources-input";
        }

        int P = resourceService.saveResource(resources);
        if (P == 0 ) {
            attributes.addFlashAttribute("message", "添加资源失败");
        } else {
            attributes.addFlashAttribute("message", "添加资源成功，管理员审核通过后即可在该页面查看，请耐心等待~");
        }
        return "redirect:/resources";

    }

}
