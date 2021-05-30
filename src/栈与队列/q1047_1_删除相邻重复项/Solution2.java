package 栈与队列.q1047_1_删除相邻重复项;

/**
 * 方法一的优化
 * 方法二：StringBuilder充当栈
 */
public class Solution2 {
    public String removeDuplicates(String s) {
        //(1)初始化栈
        //填充" "，可节省遍历时判断是否为空的操作
        StringBuilder stack = new StringBuilder();
        int n = s.length();
        //(2)遍历每个字符，重复项删除操作
        for(int i=0;i<n;i++){
            //(2.1)相等则执行重复项删除操作。PS：sLen-1指向栈顶
            char c = s.charAt(i);
            int sLen = stack.length();
            if(sLen>0 && stack.charAt(sLen-1) == c){
                stack.deleteCharAt(sLen-1);
            }else{
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
