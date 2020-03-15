package com.gp.adapters.passport.third.login;

import com.gp.adapters.passport.third.adapter.AbstractLoginAdapter;
import com.gp.adapters.passport.third.adapter.QQLoginAdapter;
import com.gp.adapters.passport.third.model.ResultMsg;

/**
 * Created by Tom.
 */
public class ThridLoginAdapter implements IThirdLogin {

    @Override
    public ResultMsg login(AbstractLoginAdapter loginAdapter) {
        return loginAdapter.login(loginAdapter);
    }
}
