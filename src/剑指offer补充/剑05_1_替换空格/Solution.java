package 剑指offer补充.剑05_1_替换空格;

/**
 * 方法一：线性遍历
 * Java：100% 30%
 * 复杂度：O(N) O(N)
 */
class Solution {
    public String replaceSpace(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}