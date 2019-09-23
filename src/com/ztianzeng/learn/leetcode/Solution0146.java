package com.ztianzeng.learn.leetcode;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LRU结构
 *
 * @author zhaotianzeng
 * @date 2019/9/21 3:23 下午
 * @version V1.0
 */
public class Solution0146 {
    @Test
    public void test() {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }

    class LRUCache {
        private int capacity;
        private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

        public LRUCache(int capacity) {

            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            } else if (map.size() == capacity) {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            map.put(key, value);
        }

    }
}