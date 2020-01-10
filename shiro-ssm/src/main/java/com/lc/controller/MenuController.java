package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @PackageName: com.lc.controller
 * @ClassName: MenuController
 * @Author: liuchen
 * @Date: 2020/1/9 11:28
 * @Description: //TODO
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @RequestMapping("goList.html")
    public String goList(){
       return "/menu_list";
    }
}
