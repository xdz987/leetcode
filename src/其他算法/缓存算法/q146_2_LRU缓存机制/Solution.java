package 其他算法.缓存算法.q146_2_LRU缓存机制;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 方法一：LinkedHashMap+LRU业务逻辑
 */
public class Solution {
    class LRUCache {

        Map<Integer,Integer> map = new LinkedHashMap<>();
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            int val = map.get(key);
            makeRecently(key,val);
            return val;
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)){
                if(map.size()>=capacity){
                    int oldestKey = map.keySet().iterator().next();
                    map.remove(oldestKey);
                }
            }else{
                map.remove(key);
            }
            map.put(key,value);
        }

        private void makeRecently(int key,int value){
            map.remove(key);
            map.put(key,value);
        }
    }
}