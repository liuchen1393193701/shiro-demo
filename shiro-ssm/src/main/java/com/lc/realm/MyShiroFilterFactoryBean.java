package com.lc.realm;

import com.lc.pojo.Menu;
import com.lc.service.MenuService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @PackageName: com.lc.realm
 * @ClassName: MyShiroFilterFactoryBean
 * @Author: liuchen
 * @Date: 2020/1/9 12:01
 * @Description: //TODO
 */
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
    @Autowired
    private MenuService menuService;
    @Override
    public void setFilterChainDefinitions(String definitions) {
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }
        //从数据库中查询
        List<Menu> all=menuService.getAllMenus();
        if (all!=null&&!all.isEmpty()){
            for (Menu menu : all) {
                String url=menu.getUrl();
                if (url!=null){
                    if (url.indexOf("/")!=-1){
                        url=url.substring(0,url.lastIndexOf("/"));
                        section.put("/"+url+"/**","perms["+url+":*]");

                    }
                }
            }
        }
        //下面这段程序主要是向控制台打印
        Set<Map.Entry<String, String>> es = section.entrySet();
        for (Map.Entry<String, String> e : es) {
            System.out.println(e.getKey()+"-----------------"+e.getValue());
        }
        this.setFilterChainDefinitionMap(section);
    }
}
