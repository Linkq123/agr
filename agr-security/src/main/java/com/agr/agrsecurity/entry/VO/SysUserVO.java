package com.agr.agrsecurity.entry.VO;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Data
public class SysUserVO {

    private long userId;

    private long deptId;

    private String loginName;

    private String userName;

    private String userType;

    private String email;

    private String phonenumber;

    private String sex;

    private String avatar;

    private String passWord;

    private String salt;

    private String status;

    private String delFlag;

    private String isExpert;

    private Date endDate;

    private String loginIp;

    private Date loginDate;

    private Date pwdUpdateDate;

    private long createId;

    private Date createTime;

    private long updateId;

    private Date updateDate;

    private String remark;

    private boolean isAdmin;

    private List<SysRoleVO> sysRole;


}
