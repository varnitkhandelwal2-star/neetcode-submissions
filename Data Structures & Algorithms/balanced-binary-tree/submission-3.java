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
    public boolean isBalanced(TreeNode root) {
         int res = 0 ;
         if (root == null){
            return true ;
         }
        
         int left = getHeight(root.left) ;
         int right = getHeight(root.right) ;
         res = left -right ;
        if(Math.abs(left - right) <= 1  && isBalanced(root.left)   
            && isBalanced(root.right))  {
            return true ;
        }else {
            return false ;
        }
    }
private int getHeight(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        return Math.max(getHeight(curr.left), getHeight(curr.right)) + 1;
    }
}