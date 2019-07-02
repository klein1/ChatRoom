package com.manage.common.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface AdminService {
    /*
       登录
    */
    public Map<String, Object> login(String adminNo, String password, HttpSession session);
}
