package 字符串.一般型题.剑58_1_翻转单词顺序;

/**
 * 方法一：双指针
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        StringBuilder res = new StringBuilder();
        //p1指向单词开头，p2指向单词结尾
        int p1 = len - 1, p2 = p1;
        while (p1 >= 0) {
            //(1)定位单词单词
            while (p1 > 0 && s.charAt(p1 - 1) != ' ') {
                p1--;
            }
            //(2)添加单词
            res.append(s, p1, p2 + 1);
            res.append(' ');
            //(3)过滤空格
            p1--;
            while (p1 >= 0 && s.charAt(p1) == ' ')
                p1--;
            //(4)调整位置
            p2 = p1;
        }
        return res.toString().trim();
    }

    //二刷
    public String reverseWords2(String s) {
        s = s.trim();
        if (s.isEmpty())
            return "";
        String[] sArr = s.split(" ");
        int n = sArr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (!sArr[i].isEmpty()) {
                sb.append(sArr[i]);
                sb.append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}
