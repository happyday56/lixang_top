package com.lgh.lixiang.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/10.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.lgh.lixiang.controller")
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new WebHandlerExceptionResolver());
    }

}
