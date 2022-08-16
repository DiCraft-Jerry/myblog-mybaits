package cn.dicraft.myblog.controller.admin;

import cn.dicraft.myblog.entity.Type;
import cn.dicraft.myblog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import javax.validation.Valid;

/**
 * @Controller注解：用于标注控制层组件
 * @RequestMapping("/admin")：建立请求URL和处理方法之间的对应关系
 * @GetMapping注解：一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写，用于将HTTP get请求映射到特定处理程序的方法注解
 * @PostMapping注解：一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写，用于将HTTP post请求映射到特定处理程序的方法注解
 * @Valid注解：请求数据校验，用来判断是否有重复的分类
 * @PathVariable注解：获取URL中的数据
 * attributes.addFlashAttribute：相当于重定向后，在URL后面拼接了参数，这样在重定向之后的页面后者控制器再去获取URL后年的参数就可以了
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 19:15
 * @package: cn.dicraft.myblog.contoller.admin
 * @Version: 1.0
 * @Decsription:
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 分页查询分类列表
     */
    @GetMapping("/types")
    public String list(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Type> list = typeService.getAllType();
        PageInfo<Type> pageInfo = new PageInfo<Type>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    /**
     * 返回新增分类页面
     */
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    /**
     * 新增分类
     */
    @PostMapping("/types")
    public String post(@Valid Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        int t = typeService.saveType(type);
        if (t == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    /**
     * 跳转修改分类页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    /**
     * 编辑修改分类
     * @param type
     * @param attributes
     * @return
     */
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        int t = typeService.updateType(type);
        if (t == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/types";
    }


    /**
     * 删除分类
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }

}
