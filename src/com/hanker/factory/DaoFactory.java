package com.hanker.factory;

import com.hanker.dao.EmployeeDao;
import com.hanker.dao.impl.EmployeeDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    private static Map<String, EmployeeDao> map = new HashMap<>();
    static {
        map.put("emp",new EmployeeDaoImpl());
        map.put("dept",new EmployeeDaoImpl());
    }
    public static EmployeeDao getBean(String key) {
        return map.get(key);
    }
    public static void close(){
        map.clear();
        map = null;
    }
}
