package 其他算法.滑动窗口.q1658_2_将x减到0的最小操作数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：前缀和，针对左右区间，即total-(sum[i]-sum[j])=x ==> sum[j]=sum[i]-total+x
 * 重点：
 * (1)元素>=1。即表示sum_j>0，则left存在操作，j+1(j为索引从0开始算需+1)；如sum_j=0则表示左边没有操作数j
 * (2)左操作数区间和+有操作数区间和=x，即sum[j]+[total-(sum[i]-sum[j])-sum[j]]=x ，即sum[j]=sum[i]-total+x
 * (3)作数数量：左=j+1或j，右=length-(i+1)。操作数量=左+右，注：当sum[j]=0则不存在操作数
 */
public class Solution {
    //前缀和
    public int minOperations1(int[] nums, int x) {
        //(1)初始化前缀和容器、总数、结果
        Map<Integer, Integer> preSum = new HashMap<>();
        int total = Arrays.stream(nums).sum();
        if(total == x)
            return nums.length;
        //存在不减左边元素操作，即sum[i]需要sum[j]为0的情况
        preSum.put(0, 0);
        int res = Integer.MAX_VALUE;

        //(2)构造前缀和并查找满足条件区间
        int sum_i = 0;
        int sum_j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_i += nums[i];

            sum_j = sum_i - total + x;
            //(3)找到满足条件区间
            if (preSum.containsKey(sum_j)) {
                //sum_j<=0说明没有操作数，j=0不是0元素的前缀和
                //j,i为索引，需+1
                int len_j = sum_j > 0 ? preSum.get(sum_j) + 1 : preSum.get(sum_j);
                int len_i = nums.length - (i + 1);
                res = Math.min(res, len_j + len_i);
            }
            preSum.put(sum_i, i);

            //(4)存在减去所有元素=x的情况
            //不存于preSum是因为存在全为1而x=length+1，结果应为-1却错误的为nums.length
            if (sum_i == sum_j) {
                res = nums.length;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
