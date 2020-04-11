package org.gp.decorator;

import java.util.List;

/**
 * @description: 菜单实现类
 * @author: Spark_tang
 * @time: 2020/3/5 21:48
 */
public abstract class Menu {

    /**
     * 登录后的菜单
     * @return
     */
    abstract List<String> getLoginMenuList();

}
