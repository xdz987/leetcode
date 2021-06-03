package 其他算法.前缀和.q523_2_连续的子数组和;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, -2, 0};
        int k = 0;
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        System.out.println(checkSubarraySum.checkSubarraySum(nums, k));
    }
}

/**
 * 类似q974 (1)只是0不是K的倍数(2)k可以为负数(3)k可以为0,false
 * 注意：子数组答案不唯一
 * 暴力前缀和 (sum[i]-sum[j])%k=0
 * 优化前缀和 sum[i]%k = sum[j]%k
 */
class CheckSubarraySum {

    //暴力前缀和
//    public boolean checkSubarraySum(int[] nums, int k) {
//        //(1)初始化前缀和容器
//        int[] sums = new int[nums.length + 1];
//        sums[0] = 0;
//
//        //(2)填充前缀和
//        int i = 1;
//        for (int num : nums) {
//            sums[i] = sums[i - 1] + num;
//            i++;
//        }
//        System.out.println(Arrays.toString(sums));
//
//        //(3)暴力前缀和
//        for (i = sums.length - 1; i > 0; i--) {
//            for (int j = 1; j < i; j++) {
//                if (i - j >= 2) {
//                    if ((sums[i] - sums[j]) % k == 0) {
//                        System.out.println(sums[i]-sums[j]);
//                        return true;
//                    }
//                }
//            }
//        }
//
//        return false;
//    }

    //优化前缀和 HashMap
    public boolean checkSubarraySum(int[] nums, int k) {
        //(1)初始化前缀和容器
        Map<Integer, Integer> preSum = new HashMap<>();
        // 因为要求子数组长度>=2，即不能单元素[n*k]
        preSum.put(0, -1);

        //(2)优化前缀和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            //k可能为0
            if (k != 0) {
                sum = sum % k;
            }

            //(3.1)当k等于0时，只要前缀和存在两个0即可，即元素>1，如[0,0] [0,-2,2,0]
            //(3.2)当k不等于0时，sum[i]%k=sum[j]%k，且距离大于1
            if (preSum.containsKey(sum)) {
                if (i - preSum.get(sum) > 1) {
                    return true;
                }
            } else {
                //存放的是[sum[i]，i]。用来判断元素数量是否>1
                preSum.put(sum, i);
            }
        }
        return false;
    }
}
