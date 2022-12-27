package com.example.springboot_mailsender_files.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@EnableWebMvc
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String home = System.getProperty("user.home");
        String path=home+File.separator+"Desktop"+File.separator+"ALL"+
                File.separator+"img"+File.separator;  /// то шукає файл має за цією директорією
        registry.addResourceHandler("/img/**")  /// якщо є такий ярлик
                .addResourceLocations("file:///"+path);
    }
}
