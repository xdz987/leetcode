package 真题ACM模式.Shopee_2022_后端A.拆分字母串与数字串;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param text_source string字符串 原始输入
     * @return string字符串
     */
    public String char_and_num_return (String text_source) {
        // write code here
        StringBuilder sb = new StringBuilder();
        String[] sArr = text_source.split(" ");
        int n = sArr.length;
        List<Long> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isNumber(sArr[i])){
                list.add(Long.parseLong(sArr[i]));
            }else{
                sb.append(sArr[i]);
                sb.append(" ");
            }
        }
        Collections.sort(list);
        for(long num:list){
            sb.append(num);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    private boolean isNumber(String s){
        for(char c:s.toCharArray()){
            if(c<'0'||c>'9')
                return false;
        }
        return true;
    }
}