package test.bean;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:49
 * @description
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + name);
    }
}
