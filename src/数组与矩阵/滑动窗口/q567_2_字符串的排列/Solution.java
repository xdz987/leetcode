package 数组与矩阵.滑动窗口.q567_2_字符串的排列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion(s1, s2));
    }
}

/**
 * 滑动(固定)窗口
 * 缩小窗口的条件为right-left超过s1的长度，返回条件为窗口内元素为s1的任意序列
 * 满足条件立即返回
 */
class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        //(1)初始化窗口指针、窗口容器、窗口字符符合条件计数值、满足条件的对照容器
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int valid = 0;

        //(2)填充满足条件的对照容器
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //滑动窗口
        while (right < s2.length()) {
            //(3)right向右拓展窗口
            char c = s2.charAt(right);
            right++;

            //(4)若字符符合need，则放入window
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                //判断window的c的数量是否符合need
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //(5)满足条件直接返回
            if (valid == need.size()) {
                return true;
            }

            //(6)若窗口长度>=s1，则向left向右缩小窗口
            if (right - left >= s1.length()) {
                char d = s2.charAt(left);
                left++;

                //(7)缩减的字符如为need所需，且先前满足条件则valid--
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                }
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
        }
        return false;
    }
}
