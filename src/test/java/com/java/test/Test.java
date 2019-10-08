package com.java.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.staff.model.StaffModel;

import java.util.Map;
import java.util.Set;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @author xs
 * @date 2019/10/7 - 20:07
 */
public class Test {
    public static void main(String[] args) {
        try {
            String jsonstr = "{\"staffModel\":{\"staffname\":\"12\",\"gender\":\"12\",\"email\":\"12\",\"photo\":\"12\",\"salary\":\"12\"}," +
                   "\"a1\":{\"staffname\":\"12\",\"gender\":\"12\",\"email\":\"12\",\"photo\":\"12\",\"salary\":\"12\"}," +
                   "\"a2\":{\"staffname\":\"12\",\"gender\":\"12\",\"email\":\"12\",\"photo\":\"12\",\"salary\":\"12\"}," +
                    "\"a3\":{\"staffname\":\"12\",\"gender\":\"12\",\"email\":\"12\",\"photo\":\"12\",\"salary\":\"12\"}}";
////            JSONObject jsonObject = parseObject(jsonstr);
//            StaffModel staffModel = JSON.toJavaObject(jsonObject, StaffModel.class);
//            System.out.println(jsonObject.toString());
            Map map = JSONObject.parseObject(jsonstr, Map.class);
            for(Object o : map.keySet()) {
                System.out.printf("%s -- %s\n", o, map.get(o));
                Object o1 = map.get(o);
                StaffModel staffModel = JSONObject.parseObject(JSON.toJSONString(o1), StaffModel.class);
                System.out.println(staffModel);            }
//
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
