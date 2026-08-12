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

class Solution {
    public int maxDepth(TreeNode root) {
       if(root == null){
        return 0;
       }

       int maxdepth = 0 ;
         Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{root, 1});

        while(!stack.isEmpty()){
             Object[] curr = stack.pop();
            TreeNode node = (TreeNode) curr[0];
            int depth = (int) curr[1];

            maxdepth = Math.max(maxdepth, depth);

            if (node.left != null)  stack.push(new Object[]{node.left,  depth + 1});
            if (node.right != null) stack.push(new Object[]{node.right, depth + 1});
        }
        return maxdepth;
    }
}
