package com.lkl.哈希;

import com.lkl.ServiceIPs;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 对机器扩容及减少进行支持
 */
public class Hash {

    private static int vm_node = 20;
    private static SortedMap<Integer,String> vMap = new TreeMap<>();
    static {
        for(String ip : ServiceIPs.LIST){
            for (int i = 0; i < vm_node; i++){
                vMap.put(getHash(ip + "VM" + i), ip);
            }
        }
    }


    public static String getServer(String client){

        int hash = getHash(client);
        SortedMap<Integer, String> subMap = vMap.tailMap(hash);
        Integer firstKey = subMap.firstKey();
        if(firstKey == null)
            firstKey = vMap.firstKey();

        return subMap.get(firstKey);
    }


    public static int getHash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        int n = key.length();
        for (int i = 0; i < n; i++)
            hash = (hash ^ key.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return (hash & 0x7FFFFFFF);
    }



    public static void main(String[] args) {
        for (int i = 0; i < 11; i++){
            System.out.println(getServer(i + ""));
        }
    }
}
