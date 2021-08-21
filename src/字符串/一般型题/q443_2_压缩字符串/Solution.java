package 字符串.一般型题.q443_2_压缩字符串;

/**
 * 方法一：StringBuilder
 */
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 1;
        char base = chars[0];
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for(int i=1;i<n;i++){
            if(chars[i] == base){
                count++;
                continue;
            }
            if(count > 1){
                sb.append(count);
            }
            sb.append(chars[i]);
            base = chars[i];
            count = 1;
        }
        if(count > 1){
            sb.append(count);
        }
        char[] res = sb.toString().toCharArray();
        for(int i=0;i<res.length;i++){
            chars[i] = res[i];
        }
        return res.length;
    }
}