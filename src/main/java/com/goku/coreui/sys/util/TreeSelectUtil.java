package com.goku.coreui.sys.util;

import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.ext.TreeSelect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/2.
 */
@Component
public class TreeSelectUtil {

        public List<TreeSelect> TreeSelectList(List<SysMenu> menu){
            List<TreeSelect> list = new ArrayList<>();
            for (SysMenu x : menu) {
                TreeSelect ts = new TreeSelect();
                if("-1".equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(TreeSelectChild(menu,x.getId()));
                    list.add(ts);
                }
            }
            return list;
        }

        public  List<TreeSelect> TreeSelectChild(List<SysMenu> menu,String id){
            List<TreeSelect> lists = new ArrayList<TreeSelect>();
            for(SysMenu x:menu){
                TreeSelect ts = new TreeSelect();
                if(id.equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(TreeSelectChild(menu,x.getId()));
                    lists.add(ts);
                }
            }
            return lists;

        }


}
