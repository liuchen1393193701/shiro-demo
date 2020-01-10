package com.lc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test()
    {
        Factory<SecurityManager> factory= new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("test","000000");
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
                System.out.println("登陆成功");
                if (subject.hasRole("admin")){
                    System.out.println("拥有admin角色");
                }else{
                    System.out.println("不拥有admin角色");
                }
                if (subject.isPermitted("add")){
                    System.out.println("拥有add方法");
                }else{
                    System.out.println("不拥有增加权限");
                }
                if (subject.isPermittedAll("add","update")){
                    System.out.println("你牛皮");
                }else{
                    System.out.println("你不牛皮");
                }
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登陆失败");
        }
        subject.logout();
    }
}
