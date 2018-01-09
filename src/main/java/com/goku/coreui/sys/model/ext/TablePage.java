package com.goku.coreui.sys.model.ext;

import java.util.List;

/**
 * Created by nbfujx on 2018/1/9.
 */
public class TablePage {
    private long total;
    private List<Object> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }
}
