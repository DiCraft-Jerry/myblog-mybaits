package cn.dicraft.myblog.config;

import cn.dicraft.myblog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Configuration注解：表明是一个有效的配置类
 * 重写addInterceptors方法
 * 指定要拦截的路径，这里拦截"admin"访问路径
 */

/**
 * @author: DiCraft
 * @Date: 2022-08-13 14:39
 * @package: cn.dicraft.myblog.config
 * @Version: 1.0
 * @Decsription:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //过滤的路径
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }
}
