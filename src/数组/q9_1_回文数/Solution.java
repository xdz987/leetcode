package 数组.q9_1_回文数;

public class Solution {
    public static void main(String[] args) {
        int x = 123464321;
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(x));
    }
}

/**
 * 左右指针
 */
class IsPalindrome {
    public boolean isPalindrome(int x) {
        char[] arrX = (String.valueOf(x)).toCharArray();
        int left = 0;
        int right = arrX.length - 1;
        while (left < right) {
            if (arrX[left] != arrX[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}