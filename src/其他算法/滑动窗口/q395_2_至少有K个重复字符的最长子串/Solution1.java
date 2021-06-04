package 其他算法.滑动窗口.q395_2_至少有K个重复字符的最长子串;

public class Solution1 {
    public static void main(String[] args) {
        String s = "ababccdddef";
        int k = 4;
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.longestSubstring(s, k));
    }
}

/**
 * 分治 递归：见分治q395
 * 滑动窗口>分治
 * 滑动窗口 枚举
 * 提示：先读代码再读这，帮助理解
 *
 * 一、枚举理解
 * 问1：为什么t需要从1~26都执行一遍？可否一些情况(s字符种类<26种字符)时t不执行到26(优化)？
 * 结论：t的值决定了符合K的连续的字符所包含的字符种类的最大长度。
 * (1)每种t(1~26)对应着a~z(26个)的26种最长的排列组合，t=满足条件最长子串种的字符种类数，才能使得less为0，从而恰当的获得最大值
 * (2)t大了，则会包含不符合k的字符，res=0
 * (3)t小了，则没有涵盖所有符合条件的字符，即使less=0，但res无法取得最大值
 * 过程：
 * - 例子1
 * kababccdddef k=2。最长子串为ababccddd，即res=9，窗口内字符种类为4
 * (1)K=2时，t=1。当执行到cc和ddd时，less=0，res=3(错)。符合结论(3)
 * (2)K=2时，t=3。当执行到ababcc，less=0，res=6(错)。符合结论(3)
 * (3)K=2时，t=5。当执行到kababccddd，less=1(包含了k而没有缩小窗口)，res=0。符合结论(2)
 * (4)k=2时，t=4。当执行到kababcc，less=1继续拓展窗口，kababccd，种类5>t4缩小窗口，ababccddd，less=0，res=9。符合结论(1)
 *
 * - 例子2
 * abcdefg...xyzxyz...gfedcba k=2，最长子串即s.length，res=52，窗口内字符种类为26
 * 此时，k=3则res=0，t=1~26都不影响结果
 * 而当，k=2时，必须是t=26，才能使得最长子串时能够涵盖a~z，使得res=52
 *
 * - 例子3
 * aaaaeebbbbbcccccdef，k=5 最长子串bbbbbccccc，res=6，串口内字符种类为2
 * 此时只有t=2才能使得res=6，因为最长子串的字符种类为2
 *
 * 二、滑动窗口
 * 重点：
 * 以下只是一种查找窗口内字符种类满足t与否 以及 字符是否满足k与否的 高效方法（这么做是为了性能，也可遍历count，但性能就低了)
 * 1. 窗口滑动的拓展与收缩
 * 1)在拓展窗口时，在拓展的第right个字符为第1次出现(数量为1)和等于k时进行记录 less total
 * 2)在缩小窗口时，在收缩的第left个字符为数量为1和小于k时进行记录 less total
 * 2. 子串最大值的查找
 * 1)由上面的结论中可发行，当t小于窗口种类total时，0<res<子串最大值(正确值)，所以需不断的取max
 *
 * 三、枚举优化（淘汰，未考虑极端测试用例如abcdabcd 2）
 * 优化1：k=1时直接返回s.length
 *
 * 优化2：减少t的循环次数，即当找到最长子串后直接break
 * 1)由部分一中的结论可知res随着t的增长而变化：
 * 当t<窗口内元素时，0<res<最长子串长度(错误)，且res的值与t成正比
 * 当t=窗口内元素时，res=最长子串长度(正确)
 * 当t>窗口内元素时，res=0
 * 2)方案：
 * 滑动窗口前保存res的值为lastRes，滑动窗口后查看res==lastRes，tre则break
 * 情况一：存在最长子串
 * 不相等，则说明当前t<滑动窗口内元素，res递增中
 * 相等，则说明当前及往后所有t>滑动窗口内元素，即res=max(res,0)，才会导致res==lastRes
 *
 * 情况二：不存在最长子串
 * res始终为0，当t=1时循环就结束
 */
class LongestSubstring {
    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }

        int res = 0;
        int len = s.length();
        //(1)枚举，窗口内最多存在t种字符(a~z)
        for (int t = 1; t <= 26; t++) {
            int left = 0;
            int right = 0;
            int[] count = new int[26];
            //窗口字符种类统计
            int totalType = 0;
            //重复次数小于k的字符类型统计
            int less = 0;

            //滑动窗口
            while (right < len) {
                //(2)right向右拓展窗口
                int rChar = s.charAt(right);
                count[rChar - 'a']++;
                //right指向的字符原本为0，此为新加入窗口字符
                if (count[rChar - 'a'] == 1) {
                    totalType++;
                    less++;
                }
                //right指向的字符原本为k-1，此字符满足条件
                if (count[rChar - 'a'] == k) {
                    less--;
                }
                //(3)字符类型超过t，left向右缩小窗口
                while (totalType > t) {
                    int lChar = s.charAt(left);
                    count[lChar - 'a']--;
                    //去掉left指向的字符后，该字符达不到k不符合条件
                    if (count[lChar - 'a'] == k - 1) {
                        less++;
                    }
                    //去掉left指向的字符后，窗口该字符数量为0
                    if (count[lChar - 'a'] == 0) {
                        totalType--;
                        less--;
                    }
                    left++;
                }
                //说明没有重复数小于k，即所有字符都>=k满足条件
                if (less == 0) {
                    res = Math.max(res, right - left + 1);
                }
                right++;
            }
        }
        return res;
    }
}
