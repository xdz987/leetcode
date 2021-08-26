package 真题ACM模式.Shopee_2022_后端A.成对69匹配;

import java.util.*;
import java.util.Stack;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param S string字符串
     * @return string字符串
     */
    public static String Paired69 (String S) {
        // write code here
        int n = S.length();
        if(n==0) return "";
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i<n || !stack.isEmpty()){
            if(i<n && arr[i] == '6'){
                sb.append('6');
                stack.push('6');
            }else{
                if(!stack.isEmpty()){
                    sb.append('9');
                    stack.pop();
                }else{
                    sb.insert(0,'6');
                    sb.append('9');
                }
            }
            i++;
        }
        return sb.toString();
    }
}