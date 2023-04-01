package com.gotten.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 10:15
 * @description
 */
public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("1", "小赵");
        map.put("2", "小钱");
        map.put("3", "小孙");
    }

    public String queryUserName(String id) {
        return map.get(id);
    }
}
