package com.ztianzeng.learn.jvm;

public class HelloWorld {
    public static void main(String[] args) {
        String subStock="local key=KEYS[1];\n" +
                "local subNum = tonumber(ARGV[1]) ;\n" +
                "local surplusStock = tonumber(redis.call('get',key));\n" +
                "if (surplusStock<=0) then return 0\n" +
                "elseif (subNum > surplusStock) then  return 1\n" +
                "else\n" +
                "    redis.call('incrby', KEYS[1], -subNum)\n" +
                "    return 2 \n" +
                "end";
        System.out.println(subStock);
    }
}
