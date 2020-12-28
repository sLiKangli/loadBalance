package com.lkl.随机;

import com.lkl.ServiceIPs;

public class Random {

    public static String getServer(){
        int rand = new java.util.Random().nextInt(ServiceIPs.LIST.size());
        return ServiceIPs.LIST.get(rand);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(getServer());
        }
    }
}
