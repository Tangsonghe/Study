package org.gp.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 未登录时候，返回的菜单
 *
 * @author: Spark_tang
 * @time: 2020/3/5 21:49
 */
public class BaseMenu extends Menu {

    @Override
    List<String> getLoginMenuList() {

        List<String> menus = new ArrayList<>();
        menus.add("问答");
        menus.add("文章");
        menus.add("精品课");
        menus.add("冒泡");
        menus.add("商城");

        return menus;
    }
}
