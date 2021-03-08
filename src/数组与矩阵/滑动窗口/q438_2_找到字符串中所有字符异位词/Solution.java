package 数组与矩阵.滑动窗口.q438_2_找到字符串中所有字符异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p ="abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s,p));
    }
}

/**
 * 滑动(固定)窗口
 * 基本和q567一样
 */
class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        int right = 0;
        int valid = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        List<Integer> res = new ArrayList();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //与q567的区别
            if (valid == need.size()) {
                res.add(left);
            }

            if (right - left >= p.length()) {
                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                }
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }

        //与q567的区别
        return res;
    }
}
