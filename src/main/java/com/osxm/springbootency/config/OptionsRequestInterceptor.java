/**  
* @Title: OptionsRequestInterceptor.java
* @Package com.osxm.springbootency.config
* @Description: TODO
* @author XM
* @date 2022年5月12日 上午6:34:31
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class OptionsRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
            // response.setHeader("Cache-Control","no-cache");
            response.setHeader("Access-control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
            response.setHeader("Access-Control-Allow-Headers", "*");
            // OPTIONS请求直接返回正常状态
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
        return true;
    }

}