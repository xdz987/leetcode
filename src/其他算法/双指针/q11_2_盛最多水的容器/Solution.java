package 其他算法.双指针.q11_2_盛最多水的容器;

public class Solution {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));
    }
}

/**
 * 暴力法(超时)
 * 双指针
 */
class MaxArea {
    //暴力法(超时)
//    public int maxArea(int[] height) {
//        int left = 0;
//        int right = 0;
//        int res = 0;
//        int area = 0;
//        while (right < height.length - 1) {
//            right++;
//
//            int tmp = left;
//            while (left < right) {
//                area = (right - left) * Math.min(height[left], height[right]);
//                res = Math.max(res, area);
//                left++;
//            }
//            left = tmp;
//        }
//        return res;
//    }
    //双指针
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int area = 0;

        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
