package 数学.进制转换.q168_1_二十六进制;

/**
 * 方法一：取模
 * Java：100% 50%
 * 复杂度：O(1) O(1)
 */
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}