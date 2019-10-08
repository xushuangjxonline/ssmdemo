package com.java.staff.handler;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.java.staff.model.StaffModel;
import com.java.staff.service.StaffService;
import com.java.staffdepartmentmapping.dao.StaffDepartmentDao;
import com.java.utils.pageUtils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;

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
    StaffService staffServiceImpl;
    @Autowired
    StaffDepartmentDao staffDepartmentDao;

    //返回list页的json 前端自己个解析
    @RequestMapping(value ="/getJson" ,method = RequestMethod.POST)
    @ResponseBody//返回json数=数据要加此行注释
    public Map<String,Object> getMapJson(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<StaffModel> list = staffServiceImpl.selectStaffList();
        map.put("code",200);
        map.put("massage","成功");
        map.put("staffList" ,list);
        return map;
    }


    //起始list页面
    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public ModelAndView select(){
        int pageNum = 1;
        ModelAndView modelAndView =new ModelAndView();
        pageBean = staffServiceImpl.selectStaffListByPaging(pageNum);
        List<StaffModel> list = pageBean.getList();
        modelAndView.addObject("list",list);
        pageBean.setList(staffServiceImpl.selectStaffList());
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("staff/list");
        return modelAndView;
    }

    //分页的方法
    @RequestMapping(value ="/pagingList" ,method = RequestMethod.GET)
    public ModelAndView pagingSelect(int pageNum){
        pageBean = staffServiceImpl.selectStaffListByPaging(pageNum);
        List<StaffModel> list = pageBean.getList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("staff/list");
        return modelAndView;
    }

    //删除单条的方法
    @RequestMapping(value = "/doDelete" ,method = RequestMethod.POST)
    public ModelAndView doDelete(int id){
        staffServiceImpl.deleteStaffModel(id);
        staffDepartmentDao.deleteMapperModelByid(id);
        return select();
    }

    //批量删除的方法
    @RequestMapping(value = "/doDel" ,method = RequestMethod.POST)
    public ModelAndView doDel(int[] checkId){
        for (int i = 0; i < checkId.length; i++) {
            staffServiceImpl.deleteStaffModel(checkId[i]);
            staffDepartmentDao.deleteMapperModelByid(checkId[i]);
        }
        return select();
    }

    //跳转添加页面的方法
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String jumpAddPage(){
        return "staff/add";
    }

    //跳转修改页面的方法
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public String jumpUpdatePage(){
        return "staff/update";
    }

    @RequestMapping(value = "/doAdd" ,method =RequestMethod.POST)
    @ResponseBody
    public ModelAndView doAdd(@RequestBody Object jsonData){
        //转换成json格式的string字符串
        String json = JSONArray.toJSONString(jsonData);
        //转换成json数组形式 (看字符串的构成形式 决定用JsonObject或者JsonArray接
        JSONArray jsonArray = JSON.parseArray(json);
        //看数组的构成形式  强转成list
        List<Map<String,Object>> list = (List<Map<String,Object>>)JSONArray.parse(json);
        Map<String,Object> map = new HashMap<String, Object>();
        //并不知道新加Model的ID 通过Model别的条件查询ID 在写进关系表里
        String staffname = null;
        int[] array = null;
        //遍历强转的list
        for (int i = 0; i < list.size(); i++) {
            StaffModel staffModel = new StaffModel();
            //遍历list 给jsonArray角标 变成标准的json字符串(JsonObject和JsonArray可操作的)
            String jsonstr = jsonArray.getString(i);
            map = JSONArray.parseObject(jsonstr,map.getClass());
            //list的泛型是map  遍历map的key
            for (Object s : map.keySet()){
                if("staffModel".equals(s)){
                    //判断外层Map的key是什么类型 然后取值 操作
                    Object o = map.get(s);
                    staffModel = JSONObject.parseObject(JSON.toJSONString(o),StaffModel.class);
                    staffname = staffModel.getStaffname();
                    //添加数据库...  我尼玛太难了
                    staffServiceImpl.insertStaffModel(staffModel);
                }else{
                    Object o = map.get(s);
                    array = JSONObject.parseObject(JSON.toJSONString(o),int[].class);
                    }
                }
            }
                int sid = staffServiceImpl.getSidByStaffname(staffname);
                for (int j = 0; j < array.length; j++) {
                    staffDepartmentDao.insertMapperModel(sid,array[j]);
                }
        return null;
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
