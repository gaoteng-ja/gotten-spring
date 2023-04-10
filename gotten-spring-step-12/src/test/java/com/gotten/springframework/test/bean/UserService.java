package com.gotten.springframework.test.bean;

import java.util.Random;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:49
 * @description
 */
public class UserService implements IUserService {

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "xg,28,ks";
    }

    @Override
    public String registerUser(String username) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + username + " 成功！";
    }
}
