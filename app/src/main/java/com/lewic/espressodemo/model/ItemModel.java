package com.lewic.espressodemo.model;

import java.io.Serializable;

/**
 * @author lewic
 * @Description:
 * @date 2020-03-24 17:41
 */
public class ItemModel implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
