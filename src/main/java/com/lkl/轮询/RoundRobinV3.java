package com.lkl.轮询;

import com.lkl.ServiceIPs;
import com.lkl.随机.Weight;

import java.util.HashMap;
import java.util.Map;

/**
 * 平滑加权轮询
 *请求次数	当前权重	当前最大权重	选取的服务器	选取后更新的权重 max(currentWeight)-totalWeight
 * 1	    5,1,1	    5	            A	            -2,1,1
 * 2	    3,2,2	    3	            A	            -4,2,2
 * 3	    1,3,3	    3	            B	            1,-4,3
 * 4	    6,-3,4	    6	            A	            -1,-3,4
 * 5	    4,-2,5	    5	            C	            4,-2,-2
 * 6	    9,-1,-1	    9	            A	            2,-1,-1
 * 7	    7,0,0	    7	            A	            0,0,0
 * 8	    5,1,1	    5	            A	            -2,1,1
 *
 */
public class RoundRobinV3 {


    private static Map<String, Weight> weightMap = new HashMap<>();

    public static String getServer(){

        if(weightMap.isEmpty()){
            for (String ip : ServiceIPs.WEIGHT_MAP.keySet()){
                int weight =  ServiceIPs.WEIGHT_MAP.get(ip);
                weightMap.put(ip, new Weight(weight, weight, ip));
            }
        }

        Weight maxWeight = null;
        for(Weight weight : weightMap.values()){
            if(maxWeight == null || weight.getCurrentWeight() > maxWeight.getCurrentWeight()){
                maxWeight = weight;
            }
        }

        int totalWeight = ServiceIPs.WEIGHT_MAP.values().stream().reduce(0, Integer::sum);
        maxWeight.setCurrentWeight(maxWeight.getCurrentWeight() - totalWeight);

        for(Weight weight : weightMap.values()){
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        return maxWeight.getIp();
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++){
            System.out.println(getServer());
        }
    }
}
