package com.gp.adapters.passport.third.adapter;

import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 22:12
 */
public class PhoneLoginAdapter extends AbstractLoginAdapter {

    private String phone;
    private String code;

    public PhoneLoginAdapter(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    @Override
    public boolean isSupport(Object obj) {
        return obj instanceof PhoneLoginAdapter;
    }

    @Override
    public ResultMsg login(ILoginAdapter loginAdapter) {
        if (!isSupport(loginAdapter)) {
            return new ResultMsg(-1, "非法登录", null);
        }
        ResultMsg resultMsg = super.loginForRegist(phone, code);
        return resultMsg.setMsg("手机号登录成功");
    }
}
