package com.gp.adapters.passport.third.adapter;

import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 22:07
 */
public class TikTokLoginAdapter extends AbstractLoginAdapter {

    private String tikTokId;

    public TikTokLoginAdapter(String tikTokId) {
        this.tikTokId = tikTokId;
    }

    @Override
    public boolean isSupport(Object obj) {
        return obj instanceof TikTokLoginAdapter;
    }

    @Override
    public ResultMsg login(ILoginAdapter login) {

        if (!isSupport(login)) {
            return new ResultMsg(-1, "非法登录", null);
        }

        ResultMsg resultMsg = super.loginForRegist(tikTokId, null);
        return resultMsg.setMsg("抖音授权登录成功");
    }
}
