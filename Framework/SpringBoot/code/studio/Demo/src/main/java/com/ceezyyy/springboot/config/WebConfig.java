package com.ceezyyy.springboot.config;

import com.ceezyyy.springboot.interceptor.InterceptorDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /* Inject to spring ioc container */
    @Bean
    InterceptorDemo interceptorDemo() {
        return new InterceptorDemo();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorDemo());
    }
}
