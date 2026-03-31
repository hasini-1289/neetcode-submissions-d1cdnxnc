class PrefixTree {

    // Trie node
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }
    private final Node root;
    public PrefixTree() {
        root = new Node();
    }
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null) {
                node.next[i] = new Node();
            }
            node = node.next[i];
        }
        node.end = true;
    }
    public boolean search(String word) {
        Node node = walk(word);
        return node != null && node.end;
    }
    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }
    private Node walk(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null) {
                return null;
            }
            node = node.next[i];
        }
        return node;
    }
}