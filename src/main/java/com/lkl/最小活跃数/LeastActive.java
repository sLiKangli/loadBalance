package com.lkl.最小活跃数;

import com.lkl.ServiceIPs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 最小活跃次数
 */
public class LeastActive {

    public static String getServer(){

       Integer min = null;
       for (Integer v : ServiceIPs.ACTIVE_MAP.values()){
           if(min == null || v < min)
               min = v;
       }

       List<String> ips = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ServiceIPs.ACTIVE_MAP.entrySet()){
           if(entry.getValue().equals(min))
               ips.add(entry.getKey());
        }

        String ip = ips.size() > 1 ? random(ips) : ips.get(0);
        Integer active = ServiceIPs.ACTIVE_MAP.get(ip);
        ServiceIPs.ACTIVE_MAP.put(ip, active+1);
        return ip;
    }

    public static String random(List<String> ips){
        int rand = new java.util.Random().nextInt(ips.size());
        return ips.get(rand);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 11; i++){
            System.out.println(getServer());
        }
    }
}
