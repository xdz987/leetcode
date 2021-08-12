package 位运算.综合统计.q318_2_最大单词长度乘积;

/**
 * 解决方案：
 * 1. int的位数是32位，小写字母是26位，可以将小写字母的数字映射到比特位的对应的位置上（如z为26则映射到右到左第26位比特位为1），对应的字符串对应着32位比特位中的数个1，重复的字符不影响，因为只需要判断字符存在于另一字符串与否
 * 2. 当str1与str2对应的32位比特，进行与运算，如为0说明没有对应字符位双方都为1，则可保存【最大单词长度乘积】
 * 方法一：位运算——与运算
 * Java：97% 65%
 * 复杂度：O(n^2) O(n)
 */
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitWords = new int[n];
        //(1)遍历每个word：将每个word对应的字符映射到bit上，如z为从右往左数第26位
        for (int i = 0; i < n; i++) {
            for(char c:words[i].toCharArray()){
                bitWords[i] |= 1<<(c-'a');
            }
        }
        int res = 0;
        //(2)暴力循环：当i与j对应的word进行"与运算"时，如果结果==0，则说明不存在相同字母
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //(2.1)不存在相同字母才进行计算
                if ((bitWords[i]&bitWords[j])==0) {
                    //(2.2)保存最大值
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}