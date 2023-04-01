package com.gotten.springframework.test.bean;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:49
 * @description
 */
public class UserService {

    private String userId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
