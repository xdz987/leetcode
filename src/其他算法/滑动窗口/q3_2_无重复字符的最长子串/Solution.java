package 其他算法.滑动窗口.q3_2_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}

/**
 * 满足条件的最大窗口
 * 缩小窗口的条件是window[字符]>1
 */
class LengthOfLongestSubstring {

    //三刷 4ms
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        boolean valid = true;
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<n){
            char c = s.charAt(right);
            if(set.contains(c)){
                valid = false;
            }else{
                set.add(c);
            }
            while(!valid){
                char d = s.charAt(left);
                if(d==c){
                    valid = true;
                }else{
                    set.remove(d);
                }
                left++;
            }
            right++;
            res = Math.max(res,right-left);
        }
        return res;
    }

    //一刷：11ms
    public int lengthOfLongestSubstring(String s) {
        //(1)初始化：窗口指针、窗口容器、长度记录
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;

        //滑动窗口
        while (right < s.length()) {
            //(2)right向右拓展窗口
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            //(3)当存在重复字符时，left向右缩减窗口
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            //(4)保存最长
            res = Math.max(res, right - left);
        }
        return res;
    }

    //二刷：7ms
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        Set<Character> window = new HashSet<>();
        int res = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (!window.contains(c)) {
                window.add(c);
                res = Math.max(res, right - left + 1);
            } else {
                char d = s.charAt(left);
                while (d != c) {
                    left++;
                    window.remove(d);
                    d = s.charAt(left);
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
