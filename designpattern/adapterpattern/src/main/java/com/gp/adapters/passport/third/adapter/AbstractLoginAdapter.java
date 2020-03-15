package com.gp.adapters.passport.third.adapter;

import com.gp.adapters.passport.third.PassportService;
import com.gp.adapters.passport.third.adapter.ILoginAdapter;
import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 22:09
 */
public abstract class AbstractLoginAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
