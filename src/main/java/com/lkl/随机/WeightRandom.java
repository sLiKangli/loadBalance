package com.lkl.随机;

import com.lkl.ServiceIPs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 权重随机1-重复放入集合
 */
public class WeightRandom {


    public static String getServer(){

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ServiceIPs.WEIGHT_MAP.entrySet()){
            for (int i = 0; i < entry.getValue(); i++){
                list.add(entry.getKey());
            }
        }

        int rand = new Random().nextInt(list.size());
        return list.get(rand);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(getServer());
        }
    }
}
