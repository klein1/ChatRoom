package com.manage.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.manage.common.dao.AdminMapper;
import com.manage.common.dao.UserMapper;
import com.manage.common.domain.Admin;
import com.manage.common.domain.User;
import com.manage.common.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/11.
 */
@RequestMapping("/")
@Controller
public class WebController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/get.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String get(HttpServletRequest request) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        Type t = new TypeToken<Map<String, Object>>() {
        }.getType();

        User user = userMapper.selectByPrimaryKey(5);
        map.put("user",user);

        return gson.toJson(map, t);
    }

    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    @ResponseBody
    public void index(HttpServletRequest request, HttpServletResponse response) {

        try {
            File file = new File("E:\\1.jpg");
            FileInputStream fis;
            fis = new FileInputStream(file);

            long size = file.length();
            byte[] temp = new byte[(int) size];
            fis.read(temp, 0, (int) size);
            fis.close();
            byte[] data = temp;
            OutputStream out = response.getOutputStream();
            response.setContentType("image/jpg");
            out.write(data);

            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
