package org.gp.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/6 20:27
 */
public class AdminMenu extends MenuDecorator {

    public AdminMenu(Menu menu) {
        super(menu);
    }

    @Override
    public List<String> getLoginMenuList() {

        List<String> adminMenus = new ArrayList<>();
        adminMenus.add("作业");
        adminMenus.add("题库");
        adminMenus.add("成长墙");
        adminMenus.add("系统管理");
        adminMenus.add("视频管理");
        adminMenus.add("学员管理");

        List<String> baseMenus = super.getLoginMenuList();
        baseMenus.addAll(adminMenus);

        return baseMenus;
    }
}
