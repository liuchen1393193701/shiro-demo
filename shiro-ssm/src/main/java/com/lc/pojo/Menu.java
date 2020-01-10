package com.lc.pojo;

import java.io.Serializable;

/**
 * @PackageName: com.lc.pojo
 * @ClassName: Menu
 * @Author: liuchen
 * @Date: 2020/1/8 21:37
 * @Description: //TODO
 */
public class Menu implements Serializable {
    private Integer id;
    private String name;
    private String icon;
    private String url;
    private Integer state;
    private Integer pId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}
