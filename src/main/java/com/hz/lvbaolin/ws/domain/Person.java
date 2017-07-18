package com.hz.lvbaolin.ws.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by master-lv on 2017/7/14.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -5939599230753662529L;
    private Long userId;
    private String username;
    private String email;
    private Date gmtCreate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
