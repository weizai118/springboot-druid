package com.gf.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: DruidConfig</p>
 * <p>Description: 配置Druid数据源 和 监控 (方法一)</p>
 *
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-05-08 10:03
 */
//@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource duridDataSource(){
        return new DruidDataSource();
    }


    /**
     * 配置Druid的监控
     * 1、配置一个管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean( new StatViewServlet() , "/druid/*" );
        Map<String , String> initParams = new HashMap<>();

        initParams.put( "loginUsername" , "admin" );
        initParams.put( "loginPassword" , "123456" );
        // ip白名单 ，（没有设置或者设置为空，则允许所有访问）
        initParams.put( "allow" , "127.0.0.1" );
        // ip黑名单，（有同值时，deny优先于allow）
        initParams.put( "deny" , "10.0.0.24" );
        bean.setInitParameters( initParams );

        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean( new WebStatFilter() );
        Map<String , String> initParams = new HashMap<>();

        initParams.put( "exclusions" , "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*" );

        bean.setInitParameters( initParams );
        bean.setUrlPatterns( Arrays.asList( "/*" ) );

        return bean;
    }



}
