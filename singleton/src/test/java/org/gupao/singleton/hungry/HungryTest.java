package org.gupao.singleton.hungry;

import static org.junit.Assert.assertTrue;

import org.gupao.singleton.hungry.HungrySingleton;
import org.junit.Test;

/**
 * Unit test for Hungry Singleton
 */
public class HungryTest
{
    /**
     * Hungry Singleton Test
     */
    @Test
    public void hungrySingletonTest()
    {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();

        System.out.println("饿汉1 === " + instance1);
        System.out.println("饿汉2 === " + instance2);

        System.out.println("饿汉1是否等于饿汉2 == " + (instance1 == instance2));
    }
}
