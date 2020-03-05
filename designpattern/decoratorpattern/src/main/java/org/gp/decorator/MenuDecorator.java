package org.gp.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/5 21:59
 */
public abstract class MenuDecorator extends Menu {

    protected Menu menu;

    public MenuDecorator(Menu menu) {
        this.menu = menu;
    }

    @Override
    protected List<String> getBaseMenuList() {
        List<String> menus = new ArrayList<>();

        menus.add("问答");
        menus.add("文章");
        menus.add("精品课");
        menus.add("冒泡");
        menus.add("商城");

        return menus;
    }

    @Override
    abstract List<String> getLoginMenuList();
}
