package 回溯.组合.q332_2_重新安排行程;

import java.util.*;

/**
 * 方法二：Hierholzer
 * Java：82% 15%
 * 抽象来看类似单链表的遍历
 * 1. 通过map快速定位起点机场
 * 2. 通过优先队列，控制机票适用与否，还能按照字典顺序排序
 * 3. 通过dfs遍历map，类似链表操作
 */
public class Solution2 {
    //初始化<起点，终点队列>
    Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //(1)将机票以map的形式存储
        for (List<String> ticket : tickets) {
            if (!ticketsMap.containsKey(ticket.get(0))) {
                ticketsMap.put(ticket.get(0), new PriorityQueue<>());
            }
            ticketsMap.get(ticket.get(0)).offer(ticket.get(1));
        }
        //(2)dfs联通所有机票
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String airport) {
        while (ticketsMap.containsKey(airport) && ticketsMap.get(airport).size() > 0) {
            //dfs字典顺序小的airport（优先队列实现）
            dfs(ticketsMap.get(airport).poll());
        }
        //在此res才能保持字典顺序
        res.add(airport);
    }
}
