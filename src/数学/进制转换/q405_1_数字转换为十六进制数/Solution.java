package 数学.进制转换.q405_1_数字转换为十六进制数;

/**
 * 方法一：位运算
 * Java：100% 66%
 * 复杂度：O(1) O(1)
 */
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        //(1)初始化十六进制字符
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        //(2)保存num&(1111/0xf)的结果即为右边位值，16进制位数=32/4=8
        while (sb.length() < 8 && num != 0) {
            sb.append(chars[num & 0xf]);
            //(3)右移4位
            num >>>= 4;
        }
        //(4)结果需取反
        return sb.reverse().toString();
    }
}