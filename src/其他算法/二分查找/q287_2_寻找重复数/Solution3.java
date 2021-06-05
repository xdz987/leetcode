package 其他算法.二分查找.q287_2_寻找重复数;

/**
 * 方法三：原地排序法 7ms
 * O(nlogn)/猜测 O(1)
 */
public class Solution3 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=1;i<=n;i++){
            while(i!=nums[i-1]){
                if(nums[i-1]==nums[nums[i-1]-1])
                    return nums[i-1];
                swap(nums,i-1,nums[i-1]-1);
            }
        }
        return -1;
    }

    private void swap(int[] nums,int i1,int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
