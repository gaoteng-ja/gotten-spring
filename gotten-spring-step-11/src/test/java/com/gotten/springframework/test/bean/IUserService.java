package com.gotten.springframework.test.bean;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 14:26
 * @description
 */
public interface IUserService {

    String queryUserInfo();

    String registerUser(String username);
}
