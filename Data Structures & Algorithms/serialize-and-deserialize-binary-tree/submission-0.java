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
    
    StringBuilder res;

    // SERIALIZE
    public String serialize(TreeNode root) {
        res = new StringBuilder();
        serDfs(root);
        return res.toString();
    }

    private void serDfs(TreeNode node) {
        if (node == null) {
            res.append("N,");
            return;
        }
        res.append(node.val + ",");
        serDfs(node.left);
        serDfs(node.right);
    }

    // DESERIALIZE
    public TreeNode deserialize(String data) {
        List<String> vals = new LinkedList<>(Arrays.asList(data.split(",")));
        return desDfs(vals);
    }

    private TreeNode desDfs(List<String> vals) {
        String val = vals.remove(0);
        if (val.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left  = desDfs(vals);
        node.right = desDfs(vals);
        return node;
    }
}
