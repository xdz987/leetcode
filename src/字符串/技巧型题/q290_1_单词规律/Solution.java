package 字符串.技巧型题.q290_1_单词规律;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：双射
 * Java：
 * 复杂度：
 */
class Solution {
    public boolean wordPattern(String s, String t) {
        int n = s.length();
        String[] tArr = t.split(" ");
        if (n != tArr.length) return false;
        Map<Character, String> s2t = new HashMap<>();
        Map<String, Character> t2s = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ss = s.charAt(i);
            String tt = tArr[i];
            //双射，不一致直接返回false
            if (s2t.containsKey(ss) && !s2t.get(ss).equals(tt) || t2s.containsKey(tt) && t2s.get(tt) != ss) {
                return false;
            }
            s2t.put(ss, tt);
            t2s.put(tt, ss);
        }
        return true;
    }
}