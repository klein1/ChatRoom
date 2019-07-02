package com.manage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class WebModelAndView {

    @RequestMapping(value = "index.htm", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView adminLogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("web/index");

        return mv;
    }

    @RequestMapping(value = "error.htm", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView error(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("web/error");

        return mv;
    }
}
