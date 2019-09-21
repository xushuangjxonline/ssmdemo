package com.java.user.handler;

import com.java.user.dao.UserDao;
import com.java.user.model.UserModel;
import com.java.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

/**
 * @author xs
 * @date 2019/9/18 - 9:32
 */
@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    UserService userServiceimpl;
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String view() {
        return "view/loginPage";
    }



    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelAndView doLogin(String username, String password) {

        ModelAndView modelAndView = new ModelAndView();

        if (userServiceimpl.isAllowLogin(username.trim(), password.trim()).equals(1)) {
            List<UserModel> list = userServiceimpl.selectUserList();
            modelAndView.addObject("userList", list);
            modelAndView.setViewName("view/success");
            return modelAndView;
        } else {
            modelAndView.setViewName("view/fail");
            return modelAndView;
        }
    }
}


