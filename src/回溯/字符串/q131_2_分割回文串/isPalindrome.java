package 回溯.字符串.q131_2_分割回文串;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("aa"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("aab"));
    }

    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        char[] wordArr = word.toCharArray();
        while (left < right) {
            if (wordArr[left] == wordArr[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
