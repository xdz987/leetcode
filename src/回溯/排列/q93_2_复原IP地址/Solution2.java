package 回溯.排列.q93_2_复原IP地址;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法二：回溯
 */
public class Solution2 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len < 4 || len > 12)
            return res;
        backTrack(s,len,0,0,new ArrayList<>());
        return res;
    }

    //判断ip是否合法：
    //(1)不能以0开头，如果长度不为1
    //(2)数值不能大于255
    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0')
            return -1;

        int sToInt = 0;
        for (int i = left; i <= right; i++) {
            sToInt = sToInt * 10 + (s.charAt(i) - '0');
        }
        if (sToInt > 255)
            return -1;
        return sToInt;
    }

    private void backTrack(String s, int len, int splitTime, int start, ArrayList<String> track) {
        //base case：start到达len长度
        if (start == len) {
            //分割4个分段成功，添加入
            if (splitTime == 4) {
                res.add(String.join(".", track));
            }
            return;
        }

        //剪枝：
        //(1)剩下的字符凑不够剩下的个分段。如字符数剩2个，还需分3个分段，肯定不够
        //(2)剩下的字符凑满分段（最多为3个字符如255）还有剩余。如字符数剩7个，还需分2个分段，多了一个字符
        if ((len - start) < (4 - splitTime) || (len - start) > 3 * (4 - splitTime)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            //start超过s的长度，break
            if (start + i >= len)
                break;

            //从start开始尝试分割
            int ipSegment = judgeIfIpSegment(s, start, start + i);
            if (ipSegment != -1) {
                track.add(ipSegment + "");
                backTrack(s, len, splitTime + 1, start + i + 1, track);
                track.remove(track.size() - 1);
            }
        }
    }
}
