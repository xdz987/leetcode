package 字符串.一般型题.面1002_2_变位数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 方法三：计数+哈希表+StringBuilder
 * Java：24% 10%
 * 复杂度：O(26*K*n)
 */
class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str:strs){
            int[] freq = new int[26];
            for(char c:str.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i:freq){
                sb.append(i);
            }
            String sStr = sb.toString();
            if(!map.containsKey(sStr)){
                map.put(sStr,new ArrayList<String>());
            }
            map.get(sStr).add(str);
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}