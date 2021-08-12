package 其他算法.缓存算法.q146_2_LRU缓存机制;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 方法一：继承LinkedHashMap实现LRU
 */
public class Solution2 {
    class LRUCache extends LinkedHashMap<Integer,Integer> {

        private int capacity;
        public LRUCache(int capacity) {
            super(capacity,0.75f,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
            return size()>capacity;
        }
    }
}