package 数学.进制转换.q504_1_七进制数;

/**
 * 方法一：取模
 * Java：33% 93%
 * 复杂度：O(n)
 */
class Solution {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        //(1)判断是否为负数
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        //(2)将取模的进制结果放入sb
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            //(2.1)更新num
            num = num / 7;
        }
        //(3)结果需要反转一次
        String res = sb.reverse().toString();
        return isNegative ? "-" + res : res;
    }
}