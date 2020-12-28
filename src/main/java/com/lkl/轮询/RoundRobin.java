package com.lkl.轮询;

import com.lkl.ServiceIPs;

/**
 * 最简单轮询
 */
public class RoundRobin {

    private static int pos = 0;

    public static String getServer(){

        if(pos >= ServiceIPs.LIST.size())
            pos = 0;

        return ServiceIPs.LIST.get(pos++);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++){
            System.out.println(getServer());
        }
    }
}
