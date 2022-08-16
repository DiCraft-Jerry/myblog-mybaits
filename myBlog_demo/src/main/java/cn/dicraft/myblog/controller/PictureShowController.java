package cn.dicraft.myblog.controller;

import cn.dicraft.myblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:53
 * @package: cn.dicraft.myblog.contoller
 * @Version: 1.0
 * @Decsription: 照片墙页面显示控制器
 */
@Controller
public class PictureShowController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String friends(Model model) {
        model.addAttribute("pictures",pictureService.listPicture());
        return "picture";
    }
}
