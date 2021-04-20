package 位运算.与运算.q338_2_比特位计数;

/**
 * 方法一：位运算——与
 * Java：65% 92%
 * 复杂度：O(n*k) O(1) 其中k为元素i最大1的位数
 */
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        //(1)遍历0~num
        for (int i = 0; i <= num; i++) {
            int tmp = i;
            //(2)当tmp不等于0时，说明存在比特位为1
            while (tmp != 0) {
                //(2.1)删除最右的1
                tmp = tmp & (tmp - 1);
                //(2.2)计数
                res[i]++;
            }
        }
        return res;
    }
}