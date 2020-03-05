package org.gp.decorator;

import java.util.List;

/**
 * @description: 菜单实现类
 * @author: Spark_tang
 * @time: 2020/3/5 21:48
 */
public abstract class Menu {

    abstract List<String> getBaseMenuList();

    abstract List<String> getLoginMenuList();

}
