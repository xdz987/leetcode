package 链表.剑35_2_复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法二：哈希表
 * 1. 使用哈希表复制新节点[node.val,新节点]
 * 2. 再遍历Head，哈希表的新节点则根据node.val(与原Head对应)赋值random
 * 3. 返回哈希表头节点
 * <p>
 * 原地法 > 哈希表(费内存空间)
 */
public class Solution2 {
    //哈希表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        Node saveHead = head;

        while (head != null) {
            map.put(head, new Node(head.val));
            head = head.next;
        }
        head = saveHead;

        while (head != null) {
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }

        return map.get(saveHead);
    }
}
