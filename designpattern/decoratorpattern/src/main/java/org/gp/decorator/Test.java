package org.gp.decorator;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/5 22:11
 */
public class Test {
    public static void main(String[] args) {
        Menu menu = new BaseMenu();
        System.out.println("未登录的菜单:" + menu.getLoginMenuList());

        menu = new StudentMenu(menu);
        System.out.println("学生登录的菜单:" + menu.getLoginMenuList());

        menu = new TeacherMenu(menu);
        System.out.println("老师登录的菜单:" + menu.getLoginMenuList());
    }
}
