package com.goku.coreui.sys.model.ext;

/**
 * Created by nbfujx on 2017/12/28.
 */
public class Breadcrumb {
    private String name;
    private String url;
    private String isleaf;
    private int order;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf;
    }
}
