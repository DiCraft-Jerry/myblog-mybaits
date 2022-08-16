package cn.dicraft.myblog.controller.admin;

import cn.dicraft.myblog.entity.User;
import cn.dicraft.myblog.service.UserService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


/**
 * @RequestMapping注解：映射请求路径
 * 登录校验：将前端传递过来的用户名和密码给service进行检验核对，并放入session域中（session是全局的，登录后访问其他页面或者重开页面也是登录状态）
 * 登录成功跳转后台管理页面，失败则跳转登录页面
 * 登录成功后可以进行注销，注销后返回登录页面
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 13:07
 * @package: cn.dicraft.myblog.contoller.admin
 * @Version: 1.0
 * @Decsription: 用户登录控制器
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @Deprecated: 跳转登录页面
     * @date: 2022-08-13 13:07
     * @return: 返回登录页面
     * @author: Dicraft
     */
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    /**
     * @Description: 登录校验
     * @Auther: Dicraft
     * @Date: 2022-08-13 13:07
     * @Param: username:用户名
     * @Param: password:密码
     * @Param: session:session域
     * @Param: attributes:返回页面消息
     * @Return: 登录成功跳转登录成功页面，登录失败返回登录页面
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            // 设置session永不过期
            session.setMaxInactiveInterval(-1);
            System.out.println("success!!!!");
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    /**
     * @Description: 注销
     * @Auther: Dicraft
     * @Date: 2022-08-13 13:07
     * @Param: session:session域
     * @Return: 返回登录页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
