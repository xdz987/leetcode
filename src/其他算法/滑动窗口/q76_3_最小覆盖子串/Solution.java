package 其他算法.滑动窗口.q76_3_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));
    }
}

/**
 * 满足条件最大窗口
 * 最小子串即要求窗口尽可能小
 */
class MinWindow {
    //13ms
    public String minWindow(String s, String t) {
        //(1)初始化：窗口指针、窗口容器、窗口字符符合条件计数值、满足条件的对照容器、满足条件的子串的始终位置
        int left = 0;
        int right = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;

        //(2)初始化need为满足题目条件
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //滑动窗口
        while (right < s.length()) {
            //(3)right向右扩展窗口
            char c = s.charAt(right);
            right++;

            //(4)判断是否为需要的字符，是则加进window
            if (need.containsKey(c)) {
                //更新window
                window.put(c, window.getOrDefault(c, 0) + 1);
                //(5)判断c是否为need，是则valid++
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //(6)判断当前window是否满足need，满足则开始缩小窗口
            while (valid == need.size()) {
                //(7)更新start和length
                if ((right - left) < (end - start)) {
                    start = left;
                    end = right;
                }

                //left向右缩小窗口
                char d = s.charAt(left);
                left++;

                //(8)判断d是否为need
                if (need.containsKey(d)) {
                    //(9)是则判断window是否达到need相同数量
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }

                    //更新window
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    //二刷：intMap 4ms
    public String minWindow2(String s, String t) {
        int n = s.length();
        int resL = 0;
        int resR = Integer.MAX_VALUE;
        int[] window = new int[58];
        int[] need = new int[58];
        int left = 0;
        int right = 0;
        int target = 0;
        int valid = 0;
        for (int c : t.toCharArray()) {
            need[c - 'A']++;
            if (need[c - 'A'] == 1)
                target++;
        }
        while (right < n) {
            int c = s.charAt(right) - 'A';
            right++;
            if (need[c] > 0) {
                window[c]++;
                if (need[c] == window[c]) {
                    valid++;
                }
            }
            while (valid == target) {
                //保存结果
                if (right - left < resR - resL) {
                    resL = left;
                    resR = right;
                }

                //收缩窗口
                int d = s.charAt(left) - 'A';
                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
                left++;
            }
        }
        if (resR == Integer.MAX_VALUE)
            return "";
        return s.substring(resL, resR);
    }
}
