package com.lkl.轮询;

import com.lkl.ServiceIPs;

import java.util.Map;

/**
 * 权重-轮询
 */
public class RoundRobinV2 {

    public static String getServer(){
        int weight = 0;
        for (int e : ServiceIPs.WEIGHT_MAP.values()){
            weight += e;
        }

        int pos = Sequence.getAndIncrement() % weight;
        for (Map.Entry<String, Integer> entry : ServiceIPs.WEIGHT_MAP.entrySet()){
            if(pos < entry.getValue())
                return entry.getKey();
            else
                pos -= entry.getValue();
        }
        return null;
    }



    public static void main(String[] args) {
        for (int i = 0; i < 50; i++){
            System.out.println(getServer());
        }
    }
}
