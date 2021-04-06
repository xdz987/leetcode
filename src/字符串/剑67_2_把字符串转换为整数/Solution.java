package 字符串.剑67_2_把字符串转换为整数;

/**
 * 直接解题
 */
public class Solution {
    public int strToInt(String str) {
        //(1)去掉空格后长度为0直接返回0
        char[] cArr = str.trim().toCharArray();
        if (cArr.length == 0) return 0;
        //(2)初始化索引下标、正负符合sign、最值边界/10的bndry、存放结果res
        int len = cArr.length;
        int i = 1;
        int sign = 1;
        int bndry = Integer.MAX_VALUE / 10;
        int res = 0;
        //(3)正负号处理
        //如为'-'：sign为-1，i从1开始
        //如为'+'：sign为1，i从1开始
        //如都不是：sign从1开始，i从0开始
        if (cArr[0] == '-')
            sign = -1;
        else if (cArr[0] != '+')
            i = 0;
        //(4)从i开始遍历每个元素
        for (int j = i; j < len; j++) {
            //(4.1)字符必须是数字
            if (cArr[j] < '0' || cArr[j] > '9')
                break;
            //(4.2)如累加的res超过了int的边界，直接返回最值
            if (res > bndry || res == bndry && cArr[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            //(4.3)res累加计算
            res = res * 10 + (cArr[j] - '0');
        }
        //(5)到此说明不是最值，根据sign正负返回值
        return sign * res;
    }
}
