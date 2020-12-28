package com.lkl.轮询;

/**
 * 请求序列号
 */
public class Sequence {

    private static int pos = 0;

    public static int getAndIncrement(){
        return pos++;
    }
}
