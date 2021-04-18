package 位运算.异或运算.q136_1_只出现一次的数字;

/**
 * 方法一：位运算——异或
 * 前置知识：a^b^b=a，a^b^c=a^b^c
 * 题解：所有数字异或一次即可。当出现两次的数字，第一次异或0等于自己，第二次自己异或自己等于0。最后操作过滤后只剩下存在奇数次的数字
 */
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            //任何数异或0等于自己，自己异或自己等于0
            single ^= num;
        }
        return single;
    }
}