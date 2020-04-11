package org.gp.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/5 22:00
 */
public class StudentMenu extends MenuDecorator {
    public StudentMenu(Menu menu) {
        super(menu);
    }

    @Override
    public List<String> getLoginMenuList() {

        List<String> studentMenus = new ArrayList<>();
        studentMenus.add("作业");
        studentMenus.add("题库");
        studentMenus.add("成长墙");

        List<String> baseMenus = super.getLoginMenuList();
        baseMenus.addAll(studentMenus);

        return baseMenus;
    }
}
