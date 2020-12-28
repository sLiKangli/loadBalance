package com.lkl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceIPs {

    public static final List<String> LIST = new ArrayList<>();

    static {
        LIST.add("192.168.1.1");
        LIST.add("192.168.1.2");
        LIST.add("192.168.1.3");
        LIST.add("192.168.1.4");
        LIST.add("192.168.1.5");
        LIST.add("192.168.1.6");
        LIST.add("192.168.1.7");
        LIST.add("192.168.1.8");
        LIST.add("192.168.1.9");
        LIST.add("192.168.1.10");
    }


    public static final Map<String,Integer> WEIGHT_MAP = new HashMap<>();
    static {
        WEIGHT_MAP.put("A",5);
        WEIGHT_MAP.put("B",1);
        WEIGHT_MAP.put("C",1);
//        WEIGHT_MAP.put("192.168.1.4",5);
//        WEIGHT_MAP.put("192.168.1.5",4);
//        WEIGHT_MAP.put("192.168.1.6",6);
//        WEIGHT_MAP.put("192.168.1.7",3);
//        WEIGHT_MAP.put("192.168.1.8",7);
//        WEIGHT_MAP.put("192.168.1.9",1);
//        WEIGHT_MAP.put("192.168.1.10",9);
    }



    public static final Map<String,Integer> ACTIVE_MAP = new HashMap<>();
    static {
        ACTIVE_MAP.put("192.168.1.1",0);
        ACTIVE_MAP.put("192.168.1.2",1);
        ACTIVE_MAP.put("192.168.1.3",5);
        ACTIVE_MAP.put("192.168.1.4",3);
        ACTIVE_MAP.put("192.168.1.5",4);
        ACTIVE_MAP.put("192.168.1.6",2);
        ACTIVE_MAP.put("192.168.1.7",0);
        ACTIVE_MAP.put("192.168.1.8",4);
        ACTIVE_MAP.put("192.168.1.9",1);
        ACTIVE_MAP.put("192.168.1.10",9);
    }

}
