package 剑指offer补充.剑17_1_打印从1到最大的n位数;

/**
 * 方法一：线性遍历
 * Java：100% 50%
 * 复杂度：O(10^N) O(10^N)
 */
class Solution {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n);
        int[] res = new int[max-1];
        for(int i=0;i<max-1;i++){
            res[i] = i+1;
        }
        return res;
    }
}