package org.gp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/8 12:51
 */
public class Department extends GPCompany {

    private List<GPCompany> companies;

    private Integer level;

    public Department(String name, Integer level) {
        super(name);
        this.level = level;
        this.companies = new ArrayList<>();
    }

    public boolean add(GPCompany company) {
        return this.companies.add(company);
    }

    public boolean addAll(List<? extends GPCompany> companies) {
        return this.companies.addAll(companies);
    }

    public boolean remove(GPCompany company) {
        return this.companies.remove(company);
    }

    @Override
    public void show() {

        System.out.println(this.name);

        for (GPCompany c : companies) {
            if (this.level != null) {
                for (int j = 0; j < this.level; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < this.level; j++) {
                    System.out.print("+");
                }
                System.out.print("-");
            }

            c.show();
        }
    }
}
