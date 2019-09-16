package com.java.department.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xs
 * @date 2019/9/16 - 2:34
 */
@Controller
@RequestMapping("/department")
public class DepartmentHandler {

    @RequestMapping("/asd")
    public String view(){
        return "view/index";
    }
}
