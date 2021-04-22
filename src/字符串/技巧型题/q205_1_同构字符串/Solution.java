package 字符串.技巧型题.q205_1_同构字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：KMP的next数组
 * Java：31% 41%
 * 复杂度：O(2n) O(2n)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        //(1)初始化双Map
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        //(2)遍历所有字符
        for (int i = 0; i < n; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            //(3.1)能够get到ss/tt，说明保存过/更新过该字符，如果同构那么另一边也【必定】能够get到。否则说明一边未存过或未更新，即不同构
            if (s2t.containsKey(ss) && s2t.get(ss) != tt || t2s.containsKey(tt) && t2s.get(tt) != ss) {
                return false;
            }
            //(3.2)
            s2t.put(ss, tt);
            t2s.put(tt, ss);
        }
        return true;
    }
}