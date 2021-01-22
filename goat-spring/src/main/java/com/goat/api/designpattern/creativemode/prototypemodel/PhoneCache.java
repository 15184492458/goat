package com.goat.api.designpattern.creativemode.prototypemodel;

import java.util.Hashtable;
import java.util.Map;

public class PhoneCache {

    private static Hashtable<String, Phone> phoneMap = new Hashtable<String, Phone>();

    public static Phone getPhone(String shapeId) {
        Phone cachedPhone = phoneMap.get(shapeId);
        return (Phone) cachedPhone.clone();
    }

    /**
     * 对每种手机都运行数据库查询，并创建该形状
     * phoneMap.put(phoneKey, phone);
     */
    public static void loadCache() {
        Phone applePhone = new ApplePhone();
        applePhone.setId("1");
        phoneMap.put(applePhone.getId(),applePhone);

        Phone miPhone = new MiPhone();
        miPhone.setId("2");
        phoneMap.put(miPhone.getId(),miPhone);
    }
}
