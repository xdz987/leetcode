package 其他算法.滑动窗口.q30_3_串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = words[0].length();
        int winSize = words.length * m;
        if (n < winSize) return res;
        Map<String, Integer> need = new HashMap<>();
        int valid = 0;
        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= n-winSize; i++) {
            Map<String, Integer> window = new HashMap<>();
            int end = i+m;
            while (end <= i + winSize) {
                String subR = s.substring(end-m, end);
                if (need.containsKey(subR)) {
                    window.put(subR, window.getOrDefault(subR, 0) + 1);
                    if (window.get(subR).equals(need.get(subR))) {
                        valid++;
                    }
                }else{
                    break;
                }
                end += m;
            }
            if (valid == need.size()) {
                res.add(i);
            }
            valid = 0;
        }
        return res;
    }
}