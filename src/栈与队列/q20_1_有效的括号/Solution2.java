package 栈与队列.q20_1_有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 方法二：栈+Map (性能较差)
 */
public class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c != map.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
