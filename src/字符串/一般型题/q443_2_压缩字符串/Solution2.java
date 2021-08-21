package 字符串.一般型题.q443_2_压缩字符串;

class Solution2 {
    public int compress(char[] chars) {
        int n = chars.length;
        char base = chars[0];
        int count = 1;
        int index = 1;
        for(int i=1;i<n;i++){
            if(chars[i] == base){
                count++;
                continue;
            }
            if(count > 1){
                index = put(chars,count,index);
            }
            chars[index++] = chars[i];
            base = chars[i];
            count = 1;
        }
        if(count > 1){
            index = put(chars,count,index);
        }
        return index;
    }
    private int put(char[] chars,int count,int index){
        if(count<10){
            chars[index++] = (char)(count+'0');
        }else if(count<100){
            chars[index++] = (char)(count/10+'0');
            chars[index++] = (char)(count%10+'0');
        }else if(count<1000){
            chars[index++] = (char)(count/100+'0');
            chars[index++] = (char)((count/10)%10+'0');
            chars[index++] = (char)(count%10+'0');
        }else{
            chars[index++] = (char)(count/1000+'0');
            chars[index++] = (char)((count/10)%10+'0');
            chars[index++] = (char)((count/100)%10+'0');
            chars[index++] = (char)(count%10+'0');
        }
        return index;
    }
}