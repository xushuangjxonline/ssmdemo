package com.java.staff.service.impl;

import com.java.staff.dao.StaffDao;
import com.java.staff.model.StaffModel;
import com.java.staff.service.StaffService;
import com.java.utils.pageUtils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xs
 * @date 2019/10/1 - 21:06
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDao staffDao;


    @Override
    public PageBean selectStaffListByPaging(Integer pageNum){
        int pageSize = 5; //自定义每页显示五条数据
        List<StaffModel> list = staffDao.selectStaffList();
        int totalRecord = list.size();
        PageBean pageBean = new PageBean(pageNum,pageSize,totalRecord);
        int startIndex = pageBean.getStartIndex();
        list = staffDao.selectStaffListByPaging(startIndex,pageSize);
        pageBean.setList(list);
        return pageBean;
    }
    @Override
    public Integer getSidByStaffname(String staffname){
        return staffDao.getSidByStaffname(staffname);
    }

    @Override
    public List<StaffModel> selectStaffList() {
        return staffDao.selectStaffList();
    }

    @Override
    public StaffModel getStaffModelBySid(Integer sid) {
        return staffDao.getStaffModelBySid(sid);
    }

    @Override
    public void insertStaffModel(StaffModel staffModel) {
        staffDao.insertStaffModel(staffModel);
    }

    @Override
    public void updateStaffModel(StaffModel staffModel) {
        staffDao.updateStaffModel(staffModel);
    }

    @Override
    public void deleteStaffModel(Integer sid) {
        staffDao.deleteStaffModel(sid);
    }
}
