package com.lgh.lixiang.model.admin;

/**
 * Created by lenovo on 2015/7/14.
 */
public class AdminBlogListRequest {
    private int type;
    private String key;
    private int current;
    private int isContentNull;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int length;

    public int getIsContentNull() {
        return isContentNull;
    }

    public void setIsContentNull(int isContentNull) {
        this.isContentNull = isContentNull;
    }
}
