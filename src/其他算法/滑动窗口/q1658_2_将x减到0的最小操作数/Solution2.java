package 其他算法.滑动窗口.q1658_2_将x减到0的最小操作数;

import java.util.Arrays;

/**
 * 方法二：滑动窗口，针对中间区间，即total-窗口内元素之和=x ==> 窗口内元素之和=total-x
 */
public class Solution2 {
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

    //二刷：5ms
    public int minOperations2(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums)
            sum+=num;
        if(sum<x)return -1;
        int target = sum-x;
        int left = 0;
        int right = 0;
        int window = 0;
        int res = Integer.MAX_VALUE;
        while(right<n){
            window+=nums[right++];
            while(window>target){
                window-=nums[left++];
            }
            if(window == target){
                res = Math.min(res,n-(right-left));
            }
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}
