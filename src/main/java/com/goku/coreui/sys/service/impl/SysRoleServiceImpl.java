package com.goku.coreui.sys.service.impl;

import com.goku.coreui.sys.mapper.ext.SysRoleAuthExtMapper;
import com.goku.coreui.sys.mapper.ext.SysRoleExtMapper;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.model.SysRoleAuth;
import com.goku.coreui.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by nbfujx on 2018/1/23.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleExtMapper sysRoleExtMapper;

    @Autowired
    SysRoleAuthExtMapper sysRoleAuthExtMapper;

    @Override
    public SysRole selectByPrimaryKey(String RoleId) {
        return sysRoleExtMapper.selectByPrimaryKey(RoleId);
    }

    @Override
    public List<SysRole> getRoleForPaging() {
        return sysRoleExtMapper.getRoleForPaging();
    }

    @Override
    public int deleteRole(String RoleId) {
        return sysRoleExtMapper.deleteByPrimaryKey(RoleId);
    }

    @Override
    public int saveRole(SysRole sysRole) {
        int addResult=0;
        if("".equals(sysRole.getId())) {
            SysRole newRole = new SysRole();
            newRole.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            newRole.setName(sysRole.getName());
            newRole.setKey(sysRole.getKey());
            newRole.setDescription(sysRole.getDescription());
            if("".equals(sysRole.getParentId())){
                newRole.setParentId("-1");
            }else{
                newRole.setParentId(sysRole.getParentId());
            }
            addResult=sysRoleExtMapper.insert(newRole);
        }else{
            SysRole newRole =sysRoleExtMapper.selectByPrimaryKey(sysRole.getId());
            newRole.setName(sysRole.getName());
            newRole.setKey(sysRole.getKey());
            newRole.setDescription(sysRole.getDescription());
            if("".equals(sysRole.getParentId())){
                newRole.setParentId("-1");
            }else{
                newRole.setParentId(sysRole.getParentId());
            }
            addResult=sysRoleExtMapper.updateByPrimaryKey(newRole);
        }
        return addResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int menuAuth(List<SysMenu> sysMenus,String roleId,String moduleId) {
        int deleteResult=0;
        int addResult=0;
        deleteResult=sysRoleAuthExtMapper.deleteRoleAuthByModuleId(roleId,moduleId);
        if(sysMenus!=null) {
            SysRoleAuth sra = null;
            for (SysMenu sr : sysMenus) {
                sra = new SysRoleAuth();
                sra.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                sra.setRoleId(roleId);
                sra.setMenuId(sr.getId());
                addResult = sysRoleAuthExtMapper.insert(sra);
            }
        }else
        {
            addResult = 1;
        }
        if (addResult == 1 && deleteResult >= 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<SysRole> getUserRoleForTree(String userid) {
        return sysRoleExtMapper.getUserRoleForTree(userid);
    }
}
