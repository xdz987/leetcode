package 回溯.排列.q93_2_复原IP地址;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：回溯，先判断截取ip是否合法再放入track
 */
public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len < 4 || len > 12)
            return res;
        backTrack(s, len, 4, 0, new ArrayList<>());
        return res;
    }

    //判断ip分割子段是否合法：
    //(1)不能以0开头，如果长度不为1
    //(2)数值不能大于255
    private boolean judgeIfIpSegment(String s, int start, int end) {
        int len = end - start + 1;
        if (len > 1 && s.charAt(start) == '0')
            return false;

        int sToInt = 0;
        for (int i = start; i <= end; i++) {
            sToInt = sToInt * 10 + (s.charAt(i) - '0');
        }

        return sToInt >= 0 && sToInt <= 255;
    }

    private void backTrack(String s, int len, int splitTime, int start, ArrayList<String> track) {
        //base case：start到达len长度
        if (start == len) {
            //分割4个分段成功，添加入res
            if (splitTime == 0) {
                res.add(String.join(".", track));
            }
            return;
        }

        for (int end = start; end < start + 3; end++) {
            //i超过s的长度，break
            if (end >= len)
                break;

            //剪枝：
            //(1)剩下的字符凑不够剩下的个分段。如字符数剩2个，还需分3个分段，肯定不够
            //(2)剩下的字符凑满分段（最多为3个字符如255）还有剩余。如字符数剩7个，还需分2个分段，多了一个字符
            if ((len - end) > 3 * splitTime || (len - end) < splitTime)
                continue;

            //尝试分割
            if (judgeIfIpSegment(s, start, end)) {
                //分割成功
                String ipSegment = s.substring(start, end + 1);
                track.add(ipSegment);
                //待分割数量splitTime-1，起点为i+1
                backTrack(s, len, splitTime - 1, end + 1, track);
                track.remove(track.size() - 1);
            }
        }
    }
}