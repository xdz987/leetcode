package 字符串.一般型题.q242_1_有效字符异位词;

/**
 * 方法一：intMap[]
 * Java：100% 95%
 * 复杂度：O(2n) O(2n)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }
        for(char c:t.toCharArray()){
            map[c-'a']--;
            if(map[c-'a']<0)
                return false;
        }
        for(int i=0;i<26;i++){
            if(map[i]!=0)
                return false;
        }
        return true;
    }
}