package 栈与队列.q1047_1_删除相邻重复项;

/**
 * 方法一的优化
 * 方法二：StringBuilder充当栈
 */
public class Solution2 {
    public String removeDuplicates(String S) {
        int len = S.length();
        char[] SArr = S.toCharArray();
        //(1)初始化栈
        //填充" "，可节省遍历时判断是否为空的操作
        StringBuilder stack = new StringBuilder(" ");
        //(2)遍历每个字符，重复项删除操作
        for (int i = 0; i < len; i++) {
            //(2.1)相等则执行重复项删除操作。PS：sLen-1指向栈顶
            int sLen = stack.length();
            if (stack.charAt(sLen - 1) == SArr[i]) {
                stack.deleteCharAt(sLen - 1);
            }
            //(2.2)不相等直接加入栈
            else {
                stack.append(SArr[i]);
            }
        }
        //(3)trim删掉第一个空格
        return stack.toString().trim();
    }
}
