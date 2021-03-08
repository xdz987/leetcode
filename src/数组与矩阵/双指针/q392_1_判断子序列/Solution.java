package 数组与矩阵.双指针.q392_1_判断子序列;

public class Solution {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence(s, t));
    }
}

/**
 * 同向条件双指针
 * 指针sp指向字符串(子序列与否)s的起点，指针tp指向字符串t的起点
 * 遍历t的字符，贪心匹配所有与s字符相等的字符，sp=s.length则说明匹配所有字符
 */
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        //(1)初始化指针
        int sp = 0;
        int tp = 0;

        //(2)遍历字符串t，判断s子序列字符是否等于字符串t字符
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();
    }
}
