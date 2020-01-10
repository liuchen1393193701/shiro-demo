package com.lc.realm;

import com.lc.service.UserService;
import com.lc.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

/**
 * @PackageName: com.lc.realm
 * @ClassName: MyRealm
 * @Author: liuchen
 * @Date: 2020/1/7 17:49
 * @Description: //TODO
 */
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    public MyRealm(){
        userService=new UserServiceImpl();
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roleNames = userService.getRoleNameByUserName(userName);
        Set<String> permissionNames = userService.getPermissionNamesByUserName(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNames);
        info.addStringPermissions(permissionNames);
        System.out.println(info);
       System.out.println("角色"+roleNames);
        System.out.println("权限"+permissionNames);
        return info;

    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        System.out.println("==============================================");
        String password = userService.getPasswordByUserName(userName);
        System.out.println(password);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, getName());
        return info;
    }
}
