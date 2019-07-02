package com.manage.web.Admin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.manage.common.dao.AdminMapper;
import com.manage.common.domain.Admin;
import com.manage.common.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/11.
 */
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    AdminMapper adminMapper;

    /*
        管理员登录
     */
    @RequestMapping(value = "/admin/login.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String adminLogin(HttpServletRequest request) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        Type t = new TypeToken<Map<String, Object>>() {
        }.getType();

        String adminNo = request.getParameter("adminNo");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        try {
            map = adminService.login(adminNo, password, session);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gson.toJson(map, t);
    }

    /*
        取消登录
     */
    @RequestMapping(value = "/admin/cancel.do", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String adminCancel(HttpServletRequest request) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        Type t = new TypeToken<Map<String, Object>>() {
        }.getType();

        HttpSession session = request.getSession();
        session.setAttribute("adminNo", null);
        map.put("returnNo", "000");

        return gson.toJson(map, t);
    }

    @RequestMapping(value = "/getData.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getData(HttpServletRequest request) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        Type t = new TypeToken<Map<String, Object>>() {
        }.getType();

        String no = request.getParameter("no");

        Admin admin = adminMapper.selectAdminByAdminNo(no);

        if(admin != null){
            map.put("returnNo", "000");
            map.put("adminId",admin.getAdminId());
            map.put("adminNo",admin.getAdminNo());
        }
        else{
            map.put("returnNo", "333");
        }

        return gson.toJson(map, t);
    }
}
