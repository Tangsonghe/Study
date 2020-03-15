package com.gp.adapters.passport.third;

import com.gp.adapters.passport.third.model.ResultMsg;
import com.gp.adapters.passport.third.model.User;

/**
 * Created by Tom.
 */
public class PassportService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password) {
        return new ResultMsg(200, "注册成功", new User(username, password));
    }

    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return new ResultMsg(200, "登录成功", new User(username,password));
    }

}
