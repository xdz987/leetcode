package 树.字典树;

public class test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("banana");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("bana"));
        System.out.println(trie.startsWith("bana"));

        System.out.println("——————————————————————");

        Trie2 trie2 = new Trie2();
        trie2.insert("有毒吗？");
        trie2.insert("吃蕉不");
        trie2.insert("猴子");
        System.out.println(trie2.search("有毒吗？"));
        System.out.println(trie2.search("猴"));
        System.out.println(trie2.startsWith("吃蕉"));
    }
}
