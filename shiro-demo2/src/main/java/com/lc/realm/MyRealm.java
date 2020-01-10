package com.lc.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @PackageName: com.lc.realm
 * @ClassName: MyRealm
 * @Author: liuchen
 * @Date: 2020/1/6 19:52
 * @Description: //TODO
 */
public class MyRealm implements Realm {

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName= (String) authenticationToken.getPrincipal();
        String password= new String((char[]) authenticationToken.getCredentials()) ;
        if (!"lc".equals(userName)){
            throw new UnknownAccountException("没有该账户");
        }
        if (!"123456".equals(password)){
            throw  new IncorrectCredentialsException("密码错误");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(userName,password,getName());
        return info;
    }
}
