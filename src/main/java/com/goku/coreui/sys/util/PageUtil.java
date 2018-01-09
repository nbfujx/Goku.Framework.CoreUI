package com.goku.coreui.sys.util;

import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.model.ext.TablePage;
import org.springframework.stereotype.Component;

/**
 * Created by nbfujx on 2018/1/9.
 */
@Component
public class PageUtil {

     public TablePage getDataForPaging(PageInfo pageInfo)
     {
         TablePage tp=new TablePage();
         tp.setTotal(pageInfo.getTotal());
         tp.setRows(pageInfo.getList());
         return tp;
     }
}
