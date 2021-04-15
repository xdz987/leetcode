package 回溯.组合.q332_2_重新安排行程;

import java.util.*;

/**
 * 方法一：回溯
 * Java：13% 82%
 */
class Solution {
    ArrayList<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //(1)初始化未使用used、先使得tickets按字典顺序小的排序
        int n = tickets.size();
        boolean[] used = new boolean[n];
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.get(0).equals(o2.get(0))) {
                    return o1.get(1).compareTo(o2.get(1));
                } else {
                    return o1.get(0).compareTo(o2.get(0));
                }
            }
        });

        //(2)遍历起点为JFK机场的ticket
        for (int i = 0; i < n; i++) {
            if (tickets.get(i).get(0).equals("JFK")) {
                ArrayList<String> track = new ArrayList<>();
                //(2.1)先填充起"JFK"起点终点，并设该ticket为未使用
                track.add(tickets.get(i).get(0));
                track.add(tickets.get(i).get(1));
                used[i] = true;
                backTrack(tickets, n, used, track, tickets.get(i).get(1));
                //(2.2)该次回溯未找到合理形成，需恢复used数组
                used[i] = false;
                //(2.3)tickets已按最小字典顺序排序，只【保存第一个】合理行程
                if (res.size() == n + 1)
                    break;
            }
        }
        return res;
    }

    private void backTrack(List<List<String>> tickets, int n, boolean[] used, ArrayList<String> track, String nextAirport) {
        //base case：N张机票的出发与目的地进行串联是N+1个机场
        if (n + 1 == track.size()) {
            res = new ArrayList<>(track);
            return;
        }

        //(1)遍历ticket
        for (int i = 0; i < n; i++) {
            //剪枝：已找到第一个合理行程直接返回
            if (res.size() == n + 1)
                return;
            //(2.1)未使用并且ticket的起点为nextAirport
            if (used[i] || !tickets.get(i).get(0).equals(nextAirport))
                continue;

            //(2.1)回溯
            track.add(tickets.get(i).get(1));
            used[i] = true;
            backTrack(tickets, n, used, track, tickets.get(i).get(1));
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }
}