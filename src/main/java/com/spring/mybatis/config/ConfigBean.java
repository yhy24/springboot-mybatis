package com.spring.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yhy
 * @Date: 2018/7/25 16:22
 * @Version 1.0
 */
@Configuration
public class ConfigBean {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean //纳入ioc容器组件
    public DataSource druid() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statVieWServlet() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/");
        System.out.println("-------2---------");
        Map<String, String> initBean = new HashMap<>();
        initBean.put("jmxUsername", "admin");
        initBean.put("jmxPassword", "123");
        servletBean.setInitParameters(initBean);
        return servletBean;
    }
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        System.out.println("-------1---------");
        filterBean.setFilter(new WebStatFilter());
        Map<String, String> initBean = new HashMap<>();
        initBean.put("exclusions", "*.js,*css,/druid/*");
        filterBean.setInitParameters(initBean);
        filterBean.setUrlPatterns(Arrays.asList("/*"));
        return filterBean;
    }




}
