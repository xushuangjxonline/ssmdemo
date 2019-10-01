package com.java.user.handler;

import com.itextpdf.text.log.SysoCounter;
import com.java.user.dao.UserDao;
import com.java.user.model.UserModel;
import com.java.user.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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




    @RequestMapping(value = "/welcome")
    public String view() {
        return "view/loginPage";
    }


    //TODO session redis   list和modeldAndView是否可以设置成单例模式?  处理登陆的方法
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelAndView doLogin(String username, String password) {

        ModelAndView modelAndView = new ModelAndView();

        if (userServiceimpl.isAllowLogin(username.trim(), password.trim()).equals(1)) {
            List<UserModel> list = userServiceimpl.selectUserList();
            modelAndView.addObject("userList", list);
            modelAndView.setViewName("view/list");
            return modelAndView;
        } else {
            modelAndView.setViewName("view/fail");
            return modelAndView;
        }
    }

    //批量删除的方法
    @RequestMapping(value = "/doDel" ,method = RequestMethod.POST)
    public  ModelAndView doDel(int[] checkId) {
        for (int i = 0; i < checkId.length; i++) {
            userServiceimpl.deleteUserModelByID(checkId[i]);
        }
        List<UserModel> list = userServiceimpl.selectUserList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", list);
        modelAndView.setViewName("view/list");
        return modelAndView;
    }

    //删除单条的方法
    @RequestMapping(value = "/doDelete" ,method = RequestMethod.POST)
    public ModelAndView doDelete(int id){
        userServiceimpl.deleteUserModelByID(id);
        List<UserModel> list = userServiceimpl.selectUserList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", list);
        modelAndView.setViewName("view/list");
        return modelAndView;
    }

    //跳转添加页面的方法
    @RequestMapping(value = "/add" )
    public String jumpAddPage(){
        return  "view/add";
    }

    //添加新管理员的方法
    @RequestMapping(value = "/doAdd" ,method =RequestMethod.POST )
    public ModelAndView doAdd(UserModel userModel){
        ModelAndView modelAndView = new ModelAndView();
        userServiceimpl.insertUserModel(userModel);
        modelAndView.addObject("userModel",userModel);
        modelAndView.setViewName("view/isContinue");
        return modelAndView;
    }

    //操作后后刷新列表页
    @RequestMapping(value = "/list")
    public ModelAndView jumpList() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserModel> list = userServiceimpl.selectUserList();
        modelAndView.addObject("userList", list);
        modelAndView.setViewName("view/list");
        return modelAndView;
    }


    //跳转到修改的方法 REST风格隐藏参数名称
    @RequestMapping(value = "/update/{uid}",method = RequestMethod.GET)
    public ModelAndView jumpUpdatePage(@PathVariable("uid") int uid){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(uid);
        UserModel userModel = userServiceimpl.getUserModelByUid(uid);
        System.out.println(userModel.toString());
        modelAndView.addObject("userModel",userModel);
        modelAndView.setViewName("view/update");
        return modelAndView;
    }


    //处理修改的方法
    @RequestMapping(value = "doUpdate" ,method = RequestMethod.POST)
    public ModelAndView doUpdate(UserModel userModel){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(userModel.toString());
        userServiceimpl.updateUserModel(userModel);
        List<UserModel> list = userServiceimpl.selectUserList();
        modelAndView.addObject("userList", list);
        modelAndView.setViewName("view/list");
        return modelAndView;
    }

/*    //跳转到详细查看页面
    @RequestMapping(value ="/view/{uid}",method = RequestMethod.GET)
    public ModelAndView jumpViewPage(@PathVariable("uid") int uid){
        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = userServiceimpl.getUserModelByUid(uid);
        modelAndView.addObject("userModel",userModel);
        modelAndView.setViewName("view/view");
        return  modelAndView;
    }*/



}



