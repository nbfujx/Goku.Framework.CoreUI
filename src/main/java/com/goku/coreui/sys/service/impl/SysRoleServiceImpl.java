package com.goku.coreui.sys.service.impl;

import com.goku.coreui.sys.mapper.ext.SysRoleExtMapper;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by nbfujx on 2018/1/23.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleExtMapper sysRoleExtMapper;

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
}
