package com.goku.coreui.sys.util;

import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.model.ext.TreeSelect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/2.
 */

//泛型通用方法改造 。。
@Component
public class TreeSelectUtil {

        public List<TreeSelect> MenuSelectTree(List<SysMenu> menu){
            List<TreeSelect> list = new ArrayList<>();
            for (SysMenu x : menu) {
                TreeSelect ts = new TreeSelect();
                if("-1".equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(MenuSelectChild(menu,x.getId()));
                    list.add(ts);
                }
            }
            Collections.reverse(list);
            return list;
        }

        public  List<TreeSelect> MenuSelectChild(List<SysMenu> menu,String id){
            List<TreeSelect> lists = new ArrayList<TreeSelect>();
            for(SysMenu x:menu){
                TreeSelect ts = new TreeSelect();
                if(id.equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(MenuSelectChild(menu,x.getId()));
                    lists.add(ts);
                }
            }
            return lists;

        }

        public List<TreeSelect> RoleSelectTree(List<SysRole> role){
            List<TreeSelect> list = new ArrayList<>();
            for (SysRole x : role) {
                TreeSelect ts = new TreeSelect();
                if("-1".equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(RoleSelectChild(role,x.getId()));
                    list.add(ts);
                }
            }
            Collections.reverse(list);
            return list;
        }

        public  List<TreeSelect> RoleSelectChild(List<SysRole> role,String id){
            List<TreeSelect> lists = new ArrayList<TreeSelect>();
            for(SysRole x:role){
                TreeSelect ts = new TreeSelect();
                if(id.equals(x.getParentId())){
                    ts.setId(x.getId());
                    ts.setName(x.getName());
                    ts.setChildren(RoleSelectChild(role,x.getId()));
                    lists.add(ts);
                }
            }
            return lists;

        }


}
