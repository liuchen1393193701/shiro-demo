package com.lc.dao;

import com.lc.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao {
    public List<Role> getAllRoles();

    /**
     * 通过userId字段查找roleId的集合
     * @param userId
     * @return
     */
    public Integer[] getRoleIdsByUserId(Integer userId);
    public void save(Map<String,Integer> params);
    public void delete(Integer userId);

}
