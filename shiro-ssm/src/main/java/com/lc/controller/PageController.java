package com.lc.controller;

import com.lc.pojo.Menu;
import com.lc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @PackageName: com.lc.controller
 * @ClassName: PageController
 * @Author: liuchen
 * @Date: 2020/1/8 10:46
 * @Description: //TODO
 */
@Controller
public class PageController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("error.html")
    public String error(){
        return "error";
    }

    @RequestMapping("leftMenu.html")
    @ResponseBody
    public List<Menu> leftMenu(){
       return this.menuService.getAllMenus();
    }
}
