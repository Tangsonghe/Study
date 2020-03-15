package com.gp.adapters.passport.third.adapter;

import com.gp.adapters.passport.third.model.ResultMsg;
import com.gp.adapters.passport.third.model.User;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 21:55
 */
public class QQLoginAdapter extends AbstractLoginAdapter {

    private String openId;

    public QQLoginAdapter(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean isSupport(Object obj) {
        return obj instanceof QQLoginAdapter;
    }

    @Override
    public ResultMsg login(ILoginAdapter login) {
        if (!isSupport(login)) {
            return new ResultMsg(-1, "非法登录", null);
        }
        ResultMsg resultMsg = super.loginForRegist(openId, null);
        return resultMsg.setMsg("QQ授权登录成功");
    }
}
