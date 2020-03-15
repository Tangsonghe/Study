package com.gp.adapters.passport.third.adapter;

import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 21:59
 */
public class WechatLoginAdapter extends AbstractLoginAdapter {

    private String openId;

    public WechatLoginAdapter(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean isSupport(Object obj) {
        return obj instanceof WechatLoginAdapter;
    }

    @Override
    public ResultMsg login(ILoginAdapter login) {
        if (!isSupport(login)) {
            return new ResultMsg(-1, "非法登录", null);
        }

        ResultMsg resultMsg = super.loginForRegist(openId, null);
        return resultMsg.setMsg("微信授权登录成功");
    }
}
