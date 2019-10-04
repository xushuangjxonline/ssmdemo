package com.java.staff.handler;

import com.java.staff.dao.StaffDao;
import com.java.staff.model.StaffModel;
import com.java.staff.service.StaffService;
import com.java.staff.service.impl.StaffServiceImpl;
import com.java.staffdepartmentmapping.dao.StaffDepartmentDao;
import com.java.staffdepartmentmapping.model.StaffDepartmentMappingModel;
import com.java.utils.pageUtils.PageBean;
import org.apache.tools.ant.taskdefs.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/1 - 15:06
 */

@Controller
@RequestMapping("/staff")
public class StaffHandler {

    PageBean pageBean;
    int totalRecord;
    int startIndex;


    @Autowired
    StaffService StaffServiceImpl;
    @Autowired
    StaffDepartmentDao staffDepartmentDao;

    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public ModelAndView select(){
        int pageNum = 1;
        ModelAndView modelAndView =new ModelAndView();
        pageBean = StaffServiceImpl.selectStaffListByPaging(pageNum);
        List<StaffModel> list = pageBean.getList();
        modelAndView.addObject("list",list);
        pageBean.setList(StaffServiceImpl.selectStaffList());
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("staff/list");
        return modelAndView;
    }

    @RequestMapping(value ="/pagingList" ,method = RequestMethod.GET)
    public ModelAndView pagingSelect(int pageNum){
        pageBean = StaffServiceImpl.selectStaffListByPaging(pageNum);
        List<StaffModel> list = pageBean.getList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("staff/list");
        return modelAndView;
    }


    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
