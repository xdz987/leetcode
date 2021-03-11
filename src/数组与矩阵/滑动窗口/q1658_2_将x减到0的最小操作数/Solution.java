package 数组与矩阵.滑动窗口.q1658_2_将x减到0的最小操作数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
//        int x = 134365;
        int[] nums = new int[]{1, 1};
        int x = 3;
//        int[] nums = new int[]{3, 2, 20, 1, 1, 3};
//        int x = 10;
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(nums, x));
    }
}

/**
 * 方法一：前缀和，针对左右区间，即total-(sum[i]-sum[j])=x ==> sum[j]=sum[i]-total+x
 * 重点：
 * (1)元素>=1。即表示sum_j>0，则left存在操作，j+1(j为索引从0开始算需+1)；如sum_j=0则表示左边没有操作数j
 * (2)左操作数区间和+有操作数区间和=x，即sum[j]+[total-(sum[i]-sum[j])-sum[j]]=x ，即sum[j]=sum[i]-total+x
 * (3)作数数量：左=j+1或j，右=length-(i+1)。操作数量=左+右，注：当sum[j]=0则不存在操作数
 * 方法二：滑动窗口，针对中间区间，即total-窗口内元素之和=x ==> 窗口内元素之和=total-x
 * 重点：同上
 */
class MinOperations {
    //前缀和
    public int minOperations1(int[] nums, int x) {
        //(1)初始化前缀和容器、总数、结果
        Map<Integer, Integer> preSum = new HashMap<>();
        int total = Arrays.stream(nums).sum();
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

    //滑动窗口
    public int minOperations(int[] nums, int x) {
        //(1)初始化结果res、窗口指针、总数和、窗口内元素和、目标窗口内元素和(换算得来)
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int total = Arrays.stream(nums).sum();
        int windowSum = 0;
        int calTarget = total - x;

        //元素之和小于x，一定无法满足条件
        if (total < x) {
            return -1;
        }

        //滑动窗口
        while (right < nums.length) {
            int rNum = nums[right];
            right++;

            //更新
            windowSum += rNum;

            //(2)当前窗口内元素超过目标时，缩小窗口
            while (windowSum > calTarget) {
                int lNum = nums[left];
                left++;

                //更新
                windowSum -= lNum;
            }

            //(3)窗口内元素满足条件，保存最小操作数结果
            if (windowSum == calTarget) {
                res = Math.min(res, left + (nums.length - right));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
