package com.lc.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @PackageName: com.lc.Utils
 * @ClassName: MybatisUtils
 * @Author: liuchen
 * @Date: 2020/1/7 17:35
 * @Description: //TODO
 */
public class MybatisUtils {

    private static SqlSessionFactory sf;
    static {
        try {
            InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
            sf=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
   /* static {
        try {
            InputStream in= MybatisUtils.class.getResourceAsStream("mybatis-config.xml");
            sf=new SqlSessionFactoryBuilder().build(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
   public static SqlSession getSession(){
        SqlSession session=sf.openSession();
       return session;
   }
   public static void closeSession(){
       SqlSession session=sf.openSession();
       if (session!=null){
           session.close();
       }

   }
}
