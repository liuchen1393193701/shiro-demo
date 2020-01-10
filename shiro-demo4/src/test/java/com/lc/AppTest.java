package com.lc;

import com.lc.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
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
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(new MyRealm());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("lc","123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        subject.checkRole("admin");
        //subject.checkPermission("user:select");


    }
}
