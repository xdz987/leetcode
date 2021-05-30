package 栈与队列.q496_1_下一个更大数1;

/**
 * 方法二：哈希表
 */
class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n2Len;i++){
            map.put(nums2[i],i);
        }
        int[] res = new int[n1Len];
        for(int i=0;i<n1Len;i++){
            res[i] = -1;
            if(map.containsKey(nums1[i])){
                for(int j=map.get(nums1[i])+1;j<n2Len;j++){
                    if(nums2[j]>nums1[i]){
                        res[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return res;
    }
}