package com.agr.agrsecurity.service;

import com.agr.agrsecurity.entry.VO.SysRoleVO;
import com.agr.agrsecurity.entry.VO.SysUserVO;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户权限处理
 * 
 * @author ruoyi
 */
@Component
public class SysPermissionService
{


    /**
     * 获取角色数据权限
     * 
     * @param user 用户信息
     * @return 角色权限信息
     */
    public Set<String> getRolePermission(SysUserVO user)
    {
//        Set<String> roles = new HashSet<String>();
//        // 管理员拥有所有权限
//        if (user.isAdmin())
//        {
//            roles.add("admin");
//        }
//        else
//        {
//            roles.addAll(roleService.selectRolePermissionByUserId(user.getUserId()));
//        }
//        return roles;
        return null;
    }

    /**
     * 获取菜单数据权限
     * 
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUserVO user)
    {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
        if (user.isAdmin())
        {
            perms.add("*:*:*");
        }
//        else
//        {
//            List<SysRoleVO> roles = user.getSysRole();
//            if (!CollectionUtils.isEmpty(roles))
//            {
//                // 多角色设置permissions属性，以便数据权限匹配权限
//                for (SysRoleVO role : roles)
//                {
//                    Set<String> rolePerms = menuService.selectMenuPermsByRoleId(role.getRoleId());
//                    role.setPermissions(rolePerms);
//                    perms.addAll(rolePerms);
//                }
//            }
//            else
//            {
//                perms.addAll(menuService.selectMenuPermsByUserId(user.getUserId()));
//            }
//        }
        return perms;
    }
}
