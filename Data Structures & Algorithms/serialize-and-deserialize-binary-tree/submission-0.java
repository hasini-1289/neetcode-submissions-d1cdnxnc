/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    void dfs(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left,sb);
        dfs(node.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }
    TreeNode build(Queue<String> q){
        String val=q.poll();
        if(val.equals("N")) return null;
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=build(q);
        node.right=build(q);
        return node;
    }
}
