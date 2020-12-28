package com.lkl.随机;

import com.lkl.ServiceIPs;

import java.util.Map;
import java.util.Random;

/**
 * 随机权重2-坐标轴思想
 */
public class WeightRandom2 {

    public static String getServer(){


        int weight = 0;
        for (int e : ServiceIPs.WEIGHT_MAP.values()){
            weight += e;
        }

        int pos = new Random().nextInt(weight);
        for (Map.Entry<String, Integer> entry : ServiceIPs.WEIGHT_MAP.entrySet()){
            if(pos < entry.getValue())
                return entry.getKey();
            else
                pos -= entry.getValue();
        }

        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(getServer());
        }
    }
}
