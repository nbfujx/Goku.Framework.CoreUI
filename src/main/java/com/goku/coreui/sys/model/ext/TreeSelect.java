package com.goku.coreui.sys.model.ext;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/12.
 */
public class TreeSelect {
    private String id;
    private String name;
    private List<TreeSelect> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<TreeSelect> children) {
        this.children = children;
    }
}
