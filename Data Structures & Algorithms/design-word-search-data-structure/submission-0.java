class WordDictionary {

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWord = false;
    }
    private final TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }
            node = node.child[idx];
        }
        node.isWord = true;
    }
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {
        if (node == null) return false;

        if (pos == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(pos);
        if (c == '.') {
            for (TrieNode next : node.child) {
                if (dfs(word, pos + 1, next)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, pos + 1, node.child[c - 'a']);
        }
    }
}