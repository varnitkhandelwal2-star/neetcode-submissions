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
 dfs(node, max_so_far):

    1. if node is None → return ___
    2. if node.value >= max_so_far → ___
    3. update max_so_far = ___
    4. call dfs on ___ and ___
    5. return the count
 *     }
 * }
 */

class Solution {
      public int goodNodes(TreeNode root) {
        return dfs(root, root.val); 
    }
   private int dfs(TreeNode node, int max) {
        if (node== null){
            return 0 ;
        }
        int count = 0 ;
        if (node.val >=max){
            max = Math.max(node.val,max) ;
            count+=1 ;
        }
        count += dfs(node.left, max);
        count += dfs(node.right, max);
       
        return count ;
    }
}
