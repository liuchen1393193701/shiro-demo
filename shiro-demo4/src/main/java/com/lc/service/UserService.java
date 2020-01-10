package com.lc.service;

import java.util.Set;

public interface UserService {
    /**
     * 通过用户名找到用户密码
     * @param userName
     * @return
     */
    public String getPasswordByUserName(String userName);

    /**
     * 通过用户名获取角色名
     * @param userName
     * @return
     */
     public Set<String> getRoleNameByUserName(String userName);

    /**
     * 通过用户名获取权限名集合
     * @param userName
     * @return
     */
    public Set<String> getPermissionNamesByUserName(String userName);

}
