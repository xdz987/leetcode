package 动态规划.最长xx子序列.最长递增子序列.q300_2_最长递增子序列;

/**
 * 方法二：DP+二分查找
 * Java：95% 73%
 * 复杂度：O(NlogN) O(N)
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //(1)初始化tail[]数组、res=0
        int[] tail = new int[n];
        int res = 0;
        //(2)遍历nums[]数组
        for (int num : nums) {
            int left = 0;
            int right = res;
            //(3)二分查找，查找num位于tail中的位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (tail[mid] < num)
                    left = mid + 1;
                else
                    right = mid;
            }
            //(3.1)更新tail数组
            //更新tail存在两种情况
            // 1. num小于tail最大/右的值且大于tail最小/左值，更新中间的数。如果后续存在比tail更小的数(即情况3)那么更新有意义，否则无意义
            // 2. num大于tail最大/右的值，增加新值
            // 3. num为tail的最小/左的值，以该更小的值为起点，可能存在更长递增子序列
            tail[left] = num;
            //(3.2)相等说明num比tail最大数还大，res递增
            //right没有发生变化，说明：
            // 1. 是第一位数字没有进while
            // 2. 进了while，但从移动过right指针，说明num比tail[]最右边的数字还大
            if (right == res)
                res++;
        }
        return res;
    }
}
