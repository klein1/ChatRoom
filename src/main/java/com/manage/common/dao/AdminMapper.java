package com.manage.common.dao;

import com.manage.common.domain.Admin;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface AdminMapper {

    /*
        根据管理员编号查询管理员信息
     */
    Admin selectAdminByAdminNo(String adminNo);
}
