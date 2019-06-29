package com.gq360.axurepermission.module.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${url}")
    private String url;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //在F:/SpringBootFiles/Image/下如果有一张 Excalibar.jpg的图片，那么：
        //【1】访问：http://localhost:8080/imgs/Excalibar.jpg 可以访问到
        //【2】html 中 <img src="imgs/Excalibar.jpg">
        //registry.addResourceHandler("/img/m/**").addResourceLocations("file:E:/var/uploaded_files/");
        registry.addResourceHandler(url).addResourceLocations("file:D:/file/");
    }

}
