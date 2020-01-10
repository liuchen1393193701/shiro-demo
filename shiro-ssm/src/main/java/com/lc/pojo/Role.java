package com.lc.pojo;

import java.io.Serializable;

/**
 * @PackageName: com.lc.pojo
 * @ClassName: Role
 * @Author: liuchen
 * @Date: 2020/1/9 20:11
 * @Description: //TODO
 */
public class Role implements Serializable {
    private Integer id;
    private String bz;
    private String name;
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
