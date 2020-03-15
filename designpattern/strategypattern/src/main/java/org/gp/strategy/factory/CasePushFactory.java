package org.gp.strategy.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 推送案件工厂
 * @author: Spark_tang
 * @time: 2020/3/15 14:51
 */
public class CasePushFactory {

    public static final String MEDIATION = "mediation";
    public static final String DAOJIAO = "daojiao";
    public static final String ZHENJIANHUI = "zhenjianhui";
    public static final String DEFAULT = MEDIATION;

    public static Map<String, ICaseService> KEYS = new HashMap<>();

    static {
        KEYS.put(MEDIATION, new MediationService());
        KEYS.put(DAOJIAO, new DaojiaoService());
        KEYS.put(ZHENJIANHUI, new ZJHService());
    }

    public static ICaseService get(String pushKey) {
        if (KEYS.containsKey(pushKey)) {
            return KEYS.get(pushKey);
        }

        return KEYS.get(DEFAULT);
    }
}
