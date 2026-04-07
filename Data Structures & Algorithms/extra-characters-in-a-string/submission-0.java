
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    private TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }
        return root;
    }
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 0;  
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                if (node.children[idx] == null) break;
                node = node.children[idx];
                if (node.isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}