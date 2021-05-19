package 位运算.综合统计.剑56_2q137_2_只出现一次的数字2;

/**
 * 方法一：遍历统计
 * Java：35% 45%
 * 复杂度：O(n) O(1)因为32是常数
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        //(1)统计所有num的比特位置
        for (int num : nums) {
            //无符号int最大值是32位，从最右到最左
            for (int i = 0; i < 32; i++) {
                //(1)取最右边的比特，第一次直接取
                count[i] += num & 1;
                //(2)num整体向右移，即更新最右边比特，【右移32次】
                num >>>= 1;
            }
        }
        //(2)找到出现一次的数
        int res = 0, m = 3;
        //存入count时，[0]为最小位，所以这里需要反过来
        for (int i = 31; i >= 0; i--) {
            //(1)整体向【左移动32次】
            res <<= 1;
            //(2)或运算，即为了保存对应比特余数
            res |= count[i] % m;
        }
        return res;
    }
}
