package com.lc.pojo;

import java.io.Serializable;

/**
 * @PackageName: com.lc.pojo
 * @ClassName: User
 * @Author: liuchen
 * @Date: 2020/1/7 11:58
 * @Description: //TODO
 */

public class User implements Serializable {
    private Integer id;
    private String userName;
    private String pwd;

    public User() {
    }

    public User(Integer id, String userName, String pwd) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
