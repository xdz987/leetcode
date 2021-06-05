package 其他算法.二分查找.q287_2_寻找重复数;

/**
 * 方法四：快慢指针
 */
public class Solution4 {
    public int findDuplicate(int[] nums) {
        //设立起点
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            //在环中相遇
            if (slow == fast) {
                //重设起点
                slow = nums[0];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                //相等说明找到了环的起点，即重复数字
                return slow;
            }
        }
    }
}
