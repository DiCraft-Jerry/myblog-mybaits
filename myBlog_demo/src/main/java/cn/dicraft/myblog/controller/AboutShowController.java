package cn.dicraft.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:05
 * @package: cn.dicraft.myblog.contoller
 * @Version: 1.0
 * @Decsription: 关于我界面显示控制器
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
