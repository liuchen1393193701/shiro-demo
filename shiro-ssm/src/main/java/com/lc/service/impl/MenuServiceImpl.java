package com.lc.service.impl;

import com.lc.dao.MenuDao;
import com.lc.pojo.Menu;
import com.lc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @PackageName: com.lc.service.impl
 * @ClassName: MenuServiceImpl
 * @Author: liuchen
 * @Date: 2020/1/8 21:42
 * @Description: //TODO
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getAllMenus() {
        return this.menuDao.getAllMenus();
    }

    @Override
    public Set<String> getUrlByUserName(String userName) {
        return this.menuDao.getUrlByUserName(userName);
    }
}
