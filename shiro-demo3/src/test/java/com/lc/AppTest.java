package com.lc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
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
    public void testJdbcRealm()
    {
        //创建jdbcRealm对象
        JdbcRealm jdbcRealm=new JdbcRealm();
        //创建DataSource
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
        String sql="select password from t_user where user_name=?";
        jdbcRealm.setUserRolesQuery(sql);
        String sql2="select t_user_role from user_role where user_name=?";
        jdbcRealm.setUserRolesQuery(sql2);

        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("lc","123456");
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
                System.out.println("登陆成功");
            }

           // subject.checkRole("admin");
         //       subject.checkPermission("user:select");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testJdbcRealm2()
    {
        //创建jdbcRealm对象
        JdbcRealm jdbcRealm=new JdbcRealm();
        //创建DataSource
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("lc","123456");
        try {
            subject.login(token);
            if (subject.isAuthenticated()){
                System.out.println("登陆成功");
            }
            subject.checkRole("admin");
             subject.checkPermission("user:select");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


    }
}
