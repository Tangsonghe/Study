package com.gp.adapters.passport.third.login;

import com.gp.adapters.passport.third.adapter.AbstractLoginAdapter;
import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 21:50
 */
public interface IThirdLogin {
    ResultMsg login(AbstractLoginAdapter loginAdapter);
}
