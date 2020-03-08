package org.gp.composite;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/8 16:26
 */
public class Tests {
    public static void main(String[] args) {
        Document doc = getDocument();

        Element root = doc.getRootElement();
        Department company = new Department(root.attributeValue("name"), 1);

        // 创始人
        Iterator founders = root.element("founders").elementIterator();
        Stuffer stuffer = null;
        while (founders.hasNext()) {
            Element founder = (Element) founders.next();
            stuffer = new Stuffer(founder.attributeValue("name"), founder.attributeValue("position"));
            company.add(stuffer);
        }

        // 部门
        Iterator departments = root.element("departments").elementIterator();

        while (departments.hasNext()) {
            Element element = (Element) departments.next();
            Department department = getDepartment(element, 2);

            company.add(department);
        }

        company.show();

    }

    private static Department getDepartment(Element element, Integer level) {

        Department department = new Department(element.attributeValue("name"), level);
        Iterator stuffers = element.element("stuffers").elementIterator();
        Stuffer stuffer = null;

        while (stuffers.hasNext()) {
            Element stufferEl = (Element)stuffers.next();
            stuffer = new Stuffer(stufferEl.attributeValue("name"), stufferEl.attributeValue("position"));

            department.add(stuffer);
        }

        if (element.element("department") != null) {
            Iterator elementIterator = element.elementIterator("department");
            while (elementIterator.hasNext()) {
                department.add(getDepartment((Element) elementIterator.next(), level + 1));
            }
        }

        return department;

    }

    private static Document getDocument() {

        Document doc = null;
        try {
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(Tests.class.getClassLoader().getResourceAsStream("gp.xml"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return doc;
    }
}
