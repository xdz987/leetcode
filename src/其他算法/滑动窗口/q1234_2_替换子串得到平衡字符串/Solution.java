package 其他算法.滑动窗口.q1234_2_替换子串得到平衡字符串;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "QQWERWWW";
        BalancedString balancedString = new BalancedString();
        System.out.println(balancedString.balancedString(s));
    }
}

/**
 * 解题：关注多余平均数的字符，如Q:1 W:4 E:3 R:4 length/4=3，关注W和R，满足条件最小替换即"WR"替换成"QQ"，长度为2。又或者WQR，长度为3
 * 满足条件最小窗口 HashMap(效率低 不推荐)
 * 满足条件最小窗口 int[]，范围单字符可转换ASCII实现mapInt[]形式
 */
class BalancedString {
    public int balancedString(String s) {
        //(1)初始化窗口指针、结果res、s各个字符数量容器
        int length = s.length();
        int left = 0;
        int right = 0;
        int balanceLen = length / 4;
        int res = length;
        int[] count = new int[26];

        //(2)统计字符数量
        for (int i = 0; i < length; i++) {
            count[s.charAt(i) - 'A']++;
        }

        //滑动窗口：以减的形式 PS：此可节约空间，即节省用于验证的容器
        while (right < length) {
            //(3)right向右拓展窗口，减少字符数量直到满足条件(没有字符数量大于balanceLen)
            int rChar = s.charAt(right);
            count[rChar - 'A']--;
            right++;

            //(4)left向右缩小窗口
            while (left < length &&
                    count['Q' - 'A'] <= balanceLen &&
                    count['E' - 'A'] <= balanceLen &&
                    count['W' - 'A'] <= balanceLen &&
                    count['R' - 'A'] <= balanceLen
            ) {
                //(5)保存最小res
                res = Math.min(res, right - left);
                int lChar = s.charAt(left);
                count[lChar - 'A']++;
                left++;
            }
        }

        return res;
    }
}
class BalancedStringMap {
    public int balancedString(String s) {
        //(1)初始化窗口指针、结果res、窗口元素容器window、目标元素容器need
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = needReplaceChar(s);

        //说明已经是平衡字符串
        if (need.isEmpty()) {
            return 0;
        }

        System.out.println(need);
        //滑动窗口
        while (right < s.length()) {
            char rChar = s.charAt(right);
            right++;
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);

            //当满足替换要求时缩小窗口
            while (isSatisfied(need, window)) {
                res = Math.min(res, right - left);

                char lChar = s.charAt(left);
                left++;
                window.put(lChar, window.get(lChar) - 1);
            }
        }

        return res;
    }

    //只有满足即>=need中字符中数量即可
    private boolean isSatisfied(HashMap<Character, Integer> need, HashMap<Character, Integer> window) {
        boolean res = true;
        for (char c : need.keySet()) {
            //window不含need的元素直接false
            if (need.containsKey(c) && !window.containsKey(c)) {
                res = false;
                break;
            } else if (window.get(c) < need.get(c)) {
                res = false;
                break;
            }
        }

        return res;
    }

    //返回"Q","W","E","R"中缺少char的map
    private HashMap<Character, Integer> needReplaceChar(String s) {
        String balance = "QWER";
        int length = s.length();
        int balanceLen = length / 4;
        HashMap<Character, Integer> need = new HashMap<>();

        //初始化need容器
        for (char c : balance.toCharArray()) {
            need.put(c, 0);
        }

        //统计字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            need.put(c, need.get(c) + 1);
        }

        //更新need为需要查找字符的map
        for (int i = 0; i < 4; i++) {
            char c = balance.charAt(i);
            int cLen = need.get(c);
            if (cLen <= balanceLen) {
                need.remove(c);
            } else {
                need.put(c, need.get(c) - balanceLen);
            }
        }

        return need;
    }
}