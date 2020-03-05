package org.gp.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/5 22:04
 */
public class TeacherMenu extends MenuDecorator {
    public TeacherMenu(Menu menu) {
        super(menu);
    }

    @Override
    public List<String> getLoginMenuList() {

        List<String> teacherMenus = new ArrayList<>();
        teacherMenus.add("作业");
        teacherMenus.add("题库");
        teacherMenus.add("成长墙");
        teacherMenus.add("管理");

        List<String> baseMenus = super.getBaseMenuList();
        teacherMenus.addAll(baseMenus);

        return teacherMenus;
    }
}
