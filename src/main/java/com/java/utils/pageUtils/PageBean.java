package com.java.utils.pageUtils;

import com.java.staff.model.StaffModel;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * @author xs
 * @date 2019/10/4 - 17:58
 */
public class PageBean implements Serializable {
    private static final long serialVersionUID = -6340807545437340448L;

    //当前页码
    private int pageNum;
    //每页显示的条数
    private  int pageSize ;
    //数据总条数
    private int totalRecord;



    //总页数
    private int totalPage;
    //起始索引  即每页第一条数据  是总数据的多少条  limit x,y中的x;
    private int startIndex;

    //每页的数据list
    private List list;



    //从外部获得的三个数据
    public PageBean(int pageNum, int pageSize,int totalRecord){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;


        if(this.pageNum == 0){
            //页面没有指定某页，显示第一页
            this.pageNum = 1;

        }


        //计算总页数
        if(totalRecord % pageSize == 0){
            this.totalPage = totalRecord / pageSize;
        }else{
            this.totalPage = (totalRecord / pageSize) + 1;
        }

        //计算起始索引	 limit x,y 的x  起始索引   limit的索引是从0开始的   y是要查找数据的条数
        this.startIndex = pageSize * (pageNum - 1);

    }






    /*------------------------------------------------------------------------------------*/




    public int getPageNum() {
        return pageNum;
    }


    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getTotalRecord() {
        return totalRecord;
    }


    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }


    public int getTotalPage() {
        return totalPage;
    }


    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public int getStartIndex() {
        return startIndex;
    }


    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}


