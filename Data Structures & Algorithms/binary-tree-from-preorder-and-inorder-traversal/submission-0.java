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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case: no elements = no tree
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // step 1: first element of preorder is always root
        TreeNode root = new TreeNode(preorder[0]);

        // step 2: find root in inorder to split left and right
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        // step 3: recurse
        // left subtree:
        //   preorder → from index 1 to mid+1
        //   inorder  → from index 0 to mid
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, mid + 1),
            Arrays.copyOfRange(inorder, 0, mid)
        );

        // right subtree:
        //   preorder → from index mid+1 to end
        //   inorder  → from index mid+1 to end
        root.right = buildTree(
            Arrays.copyOfRange(preorder, mid + 1, preorder.length),
            Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }
}