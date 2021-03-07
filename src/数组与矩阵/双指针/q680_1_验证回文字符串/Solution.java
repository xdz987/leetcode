package 数组与矩阵.双指针.q680_1_验证回文字符串;

public class Solution {
    public static void main(String[] args) {
        String s = "abba";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome(s));
    }
}

/**
 * 左右指针
 * 左右指针判断是否相等，并同时向中间靠拢
 */
class ValidPalindrome {
    public boolean validPalindrome(String s) {
        //(1)初始化边界
        int left = 0;
        int right = s.length() - 1;

        //(2)查找需要删除的字符，即不等于另一边对应位置字符
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                //删除左/右边的字符，看是否为回文字符串
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }

        //到此说明判断到达中间，即为abba的情况，b=b跳出了循环，但去除一个'b'一定为回文字符串
        return true;
    }

    //判断是否为回文字符串
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}