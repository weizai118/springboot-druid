package com.gf.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * <p>Title: DruidStatFilter</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author guofu
 * @version 1.0
 * @date 2018-05-08 11:12
 */
@WebFilter(
        filterName = "druidWebStatFilter" ,
        urlPatterns = "/*",
        initParams = {
                @WebInitParam( name = "exclusions" , value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        }
)
public class DruidStatFilter extends WebStatFilter{
}
