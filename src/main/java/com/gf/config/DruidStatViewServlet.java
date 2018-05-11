package com.gf.config;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * <p>Title: DruidStatViewServlet</p>
 * <p>Description: 配置Druid数据源 和 监控 （方法二）</p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-05-08 10:59
 */
@WebServlet(
        urlPatterns = {"/druid/*"},
        initParams = {
                @WebInitParam( name = "loginUsername" , value = "admin"),
                @WebInitParam( name = "loginPassword" , value = "123456"),
                @WebInitParam( name = "allow" , value = ""),
                //@WebInitParam( name = "deny" , value = "10.0.0.24"),
                // 禁用html 页面上的 "Reset All" 功能
                @WebInitParam( name = "resetEnable" , value = "false"),
        }
)
public class DruidStatViewServlet extends StatViewServlet{
}
