package com.lc.realm;

import com.lc.pojo.User;
import com.lc.service.MenuService;
import com.lc.service.UserService;
import com.lc.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName: com.lc.realm
 * @ClassName: MyShiroRealm
 * @Author: liuchen
 * @Date: 2020/1/8 10:30
 * @Description: //TODO
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("*************授权的时候调用********************");
        Subject subject= SecurityUtils.getSubject();
        Session session = subject.getSession();
        User sessionUser = (User) session.getAttribute(Constants.SESSION_USER);
        Set<String> permissionList = menuService.getUrlByUserName(sessionUser.getUserName());
        HashSet<String> all = new HashSet<>();
        if (permissionList!=null&&!permissionList.isEmpty()){
            for (String url : permissionList) {
                if (url.indexOf("/")!=-1){
                    url=url.substring(0,url.lastIndexOf("/"));
                    all.add(url+":*");
                }
            }
        }
        System.out.println("??????????????????????????????????????????????");
        for (String s : all) {
            System.out.println(s);
        }
        System.out.println("??????????????????????????????????????????????");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(all);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("*************认证的时候调用********************");
        String userName = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByUserName(userName);

        return new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
    }
}
