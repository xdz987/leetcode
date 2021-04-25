package 数学.字符串加法减法.q415_1_字符串相加;

/**
 * 方法一：模拟
 * Java：100% 75%
 * 复杂度：O(logN) O(1)
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (carry != 0 || i >= 0 || j >= 0) {
            if (i >= 0)
                carry += num1.charAt(i--) - '0';
            if (j >= 0)
                carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}