package 字符串.一般型题.面1002_2_变位数组;

import java.util.*;

/**
 * 方法二：排序
 * Java：96% 56%
 * 复杂度：O(nKlogK) O(nKlogK)
 */
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str:strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sStr = new String(cs);
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