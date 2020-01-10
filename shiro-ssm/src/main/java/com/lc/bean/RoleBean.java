package com.lc.bean;

import com.lc.pojo.Role;

/**
 * @PackageName: com.lc.bean
 * @ClassName: RoleBean
 * @Author: liuchen
 * @Date: 2020/1/9 20:41
 * @Description: //TODO
 */
public class RoleBean {
    private Role role;
    private String checked="";//该属性主要的作用是用于前端页面来进行勾选

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
