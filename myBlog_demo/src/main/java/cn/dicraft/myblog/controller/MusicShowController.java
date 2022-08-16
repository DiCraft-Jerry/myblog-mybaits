package cn.dicraft.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:52
 * @package: cn.dicraft.myblog.contoller
 * @Version: 1.0
 * @Decsription: 音乐盒页面显示控制器
 */

@Controller
public class MusicShowController {
    @GetMapping("/music")
    public String about() {
        return "music";
    }

}
