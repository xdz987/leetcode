package 数组与矩阵.前缀和.q1248_2_统计优美子数组;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        System.out.println(numberOfSubarrays.numberOfSubarrays(nums, k));
    }
}


/**
 * 方法一：可变窗口+思路
 * (1)right拓展窗口至条件满足k位奇数，计算窗口内第一个奇数与第K个奇数，到最两侧的所有可能性：res=(窗口第一个奇数左边偶数和+1)*(窗口最后奇数偶数和+1)
 * (2)left缩小窗口，重复(1)的过程
 * 方法二：前缀和结合题目(推荐)
 * 同q560
 */
class NumberOfSubarrays {
    //滑动窗口
//    public int numberOfSubarrays(int[] nums, int k) {
//        //(1)初始化窗口边界、窗口状态计数器、结果res
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//        int res = 0;
//
//        //滑动窗口
//        while (right < nums.length) {
//            //(2)right向右拓展窗口直到满足条件K
//            int rNum = nums[right];
//            right++;
//            if ((rNum & 1) == 1) {
//                valid++;
//            }
//
//            //(3)当满足条件K时，计算左右拓展任意个偶数的可能
//            if (valid == k) {
//                //(3.1)计算窗口最后一个奇数右边的偶数。此时right指向窗口外右边的第一个奇数或者结尾元素
//                int tmp = right;
//                while (right < nums.length && (nums[right] & 1) == 0) {
//                    right++;
//                }
//                int rightEvenCnt = right - tmp;
//
//                //(3.2)计算窗口内第一个奇数左边的偶数。此时left指针指向窗口的第一个奇数
//                int leftEvenCnt = 0;
//                while ((nums[left] & 1) == 0) {
//                    leftEvenCnt++;
//                    left++;
//                }
//
//                //(4)保存当前窗口优美子数组可能
//                res += (rightEvenCnt + 1) * (leftEvenCnt + 1);
//
//                //(5)left向右缩小窗口
//                left++;
//                valid--;
//            }
//        }
//        return res;
//    }
    public int numberOfSubarrays(int[] nums, int k) {
        //(1)初始化前缀和容器、结果res、奇数总数sum
        int[] preSum = new int[nums.length + 1];
        //第一个优美子数组的起点+1，即无偶数起点
        preSum[0] = 1;
        int res = 0;
        int sum = 0;


        //(2)计算前缀和并累加满足条件区间(优美子数组)
        for (int num : nums) {
            //如果为奇数则sum++
            sum += num & 1;
            //对应奇数前缀和+1
            preSum[sum]++;

            //(3)总奇数满足k，则累加优美子数组的组合数
            if (sum >= k) {
                //优美子数组的可能排列 = 起点（第一个奇数左边偶数+1） * （终点第k个奇数右边偶数+1）
                //而此即为 res+=起点数 * 1(终点) 。配合该循环会执行(右边偶数+1)次，刚好等于↑↑↑
                res += preSum[sum - k];
            }
        }

        return res;
    }
}
