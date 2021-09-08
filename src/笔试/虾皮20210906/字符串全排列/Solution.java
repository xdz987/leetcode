package 笔试.虾皮20210906.字符串全排列;

import java.util.*;



public class Solution {
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        char[] cArr = s.toCharArray();
        backTrack(cArr,0,list);
        return list.toArray(new String[list.size()]);
    }

    private void backTrack(char[] sArr,int start,List<String> list){
        if(start == sArr.length){
            list.add(new String(sArr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=start;i<sArr.length;i++){
            if(set.contains(sArr[i]))
                continue;
            set.add(sArr[i]);
            swap(sArr,start,i);
            backTrack(sArr,start+1,list);
            swap(sArr,start,i);
        }
    }
    private void swap(char[] sArr,int i1,int i2){
        if(i1!=i2){
            char tmp = sArr[i1];
            sArr[i1] = sArr[i2];
            sArr[i2] = tmp;
        }
    }
}
