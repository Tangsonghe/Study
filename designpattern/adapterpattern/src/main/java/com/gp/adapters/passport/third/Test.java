package com.gp.adapters.passport.third;

import com.gp.adapters.passport.third.adapter.PhoneLoginAdapter;
import com.gp.adapters.passport.third.adapter.QQLoginAdapter;
import com.gp.adapters.passport.third.adapter.TikTokLoginAdapter;
import com.gp.adapters.passport.third.adapter.WechatLoginAdapter;
import com.gp.adapters.passport.third.login.IThirdLogin;
import com.gp.adapters.passport.third.login.ThridLoginAdapter;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 22:14
 */
public class Test {
    public static void main(String[] args) {
        IThirdLogin thirdLogin = new ThridLoginAdapter();
        System.out.println(thirdLogin.login(new QQLoginAdapter("QQMDdkakakalaldasdas")));
        System.out.println(thirdLogin.login(new WechatLoginAdapter("WCdkaldddddddddddd")));
        System.out.println(thirdLogin.login(new TikTokLoginAdapter("TKKddddddddddddsssss")));
        System.out.println(thirdLogin.login(new PhoneLoginAdapter("136555555555", "222530")));

    }
}
