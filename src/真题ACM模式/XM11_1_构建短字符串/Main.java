package 真题ACM模式.XM11_1_构建短字符串;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] freq = new int[26];
        String shortS = in.next();
        for(char c:in.next().toCharArray()){
            freq[c-'a']++;
        }
        for(char c:shortS.toCharArray()){
            if(--freq[c-'a']<0){
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}