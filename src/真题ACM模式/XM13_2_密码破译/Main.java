package 真题ACM模式.XM13_2_密码破译;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    final static char[] RECORD = new char[]{
            ' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'
    };
    static StringBuilder res;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(bf.ready()){
            String number = bf.readLine();
            res = new StringBuilder();
            dfs(number.toCharArray(),0,new StringBuilder(),false);
            System.out.println(res.toString().trim());
        }
    }
    //flag：标志前一个转换的字母是否大于9
    //传递start作为下标
    private static void dfs(char[] sArr,int start,StringBuilder track,boolean flag){
        if(start == sArr.length){
            res.append(track.toString());
            res.append(" ");
            return;
        }
        if(sArr[start]>'0' && sArr[start]<='9'){
            dfs(sArr,start+1,new StringBuilder(track).append(RECORD[sArr[start]-'0']),false);
        }
        //前一个字母由<=9组成才可与当前字母组合
        if(!flag && start>0 && (sArr[start-1] == '1' || (sArr[start-1] == '2' && sArr[start]<='6'))){
            StringBuilder copy = new StringBuilder(track);
            copy.deleteCharAt(copy.length()-1);
            int RIndex = (sArr[start-1]-'0')*10+(sArr[start]-'0');
            copy.append(RECORD[RIndex]);
            dfs(sArr,start+1,copy,true);
        }
    }
}