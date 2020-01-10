package com.lc.dao;

import com.lc.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MenuDao {
    public List<Menu> getAllMenus();
    public Set<String> getUrlByUserName(String userName);
}
