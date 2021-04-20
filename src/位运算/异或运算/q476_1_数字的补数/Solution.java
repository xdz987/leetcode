package 位运算.异或运算.q476_1_数字的补数;

/**
 * 方法一：位运算——异或
 * Java：100% 86%
 * 复杂度：O(K) O(1) 其中K为num最最左边1到最右边数量
 */
class Solution {
    public int findComplement(int num) {
        int size = 0;
        int tmpNum = num;
        //(1)计数num最左边的1到最右的数量
        while (tmpNum != 0) {
            tmpNum >>>= 1;
            size++;
        }
        //(2)异或num和与之同样二进制位的全1。
        return num ^ ((1 << size) - 1);
    }
}