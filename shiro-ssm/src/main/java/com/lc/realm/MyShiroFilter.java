package com.lc.realm;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @PackageName: com.lc.realm
 * @ClassName: MyShiroFilter
 * @Author: liuchen
 * @Date: 2020/1/9 11:47
 * @Description: //TODO
 */
public class MyShiroFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject=super.getSubject(servletRequest,servletResponse);
        String roles[]= (String[]) o;
        if (roles==null&&roles.length==0){
            return true;
        }
        for (String role : roles) {
            if (subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
