package com.manage.common.impl;

import com.manage.common.dao.AdminMapper;
import com.manage.common.domain.Admin;
import com.manage.common.service.AdminService;
import com.manage.function.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/11.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    /*
        登录
     */
    public Map<String, Object> login(String adminNo, String password, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();

        Admin admin = adminMapper.selectAdminByAdminNo(adminNo);

        if (admin != null){
            if ((MD5Util.MD5(password)).equals(admin.getPassword())){
                map.put("returnNo", "000");
                session.setAttribute("adminNo", adminNo);
            }else {
                map.put("returnNo", "333");
                map.put("errorMsg", "用户名或密码错误");
            }
        }else {
            map.put("returnNo", "333");
            map.put("errorMsg", "用户不存在");
        }

        return map;
    }
}
