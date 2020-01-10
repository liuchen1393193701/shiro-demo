package com.lc.pojo;

import java.io.Serializable;

/**
 * @PackageName: com.lc.pojo
 * @ClassName: User
 * @Author: liuchen
 * @Date: 2020/1/8 9:15
 * @Description: //TODO
 */
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String trueName;//真实姓名
    private String bz;//描述
    private String remarks;//备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
