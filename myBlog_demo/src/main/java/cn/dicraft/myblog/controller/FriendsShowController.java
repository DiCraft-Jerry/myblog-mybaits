package cn.dicraft.myblog.controller;

import cn.dicraft.myblog.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: DiCraft
 * @Date: 2022-08-15 13:10
 * @package: cn.dicraft.myblog.contoller
 * @Versio: 1.0
 * @Decsription: 友链显示控制器
 */
@Controller
public class FriendsShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friends(Model model) {
        model.addAttribute("friendlinks",friendLinkService.listFriendLink());
        return "friends";
    }

}
