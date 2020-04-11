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
    public List<String> getLoginMenuList() {
        return this.menu.getLoginMenuList();
    }
}
