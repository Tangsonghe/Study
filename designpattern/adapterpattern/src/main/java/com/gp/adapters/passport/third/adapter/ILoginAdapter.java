package com.gp.adapters.passport.third.adapter;

import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/10 22:23
 */
public interface ILoginAdapter {
    boolean isSupport(Object object);
    ResultMsg login(ILoginAdapter adapter);
}
