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
    public static void helper(TreeNode root, ArrayList<Integer> save){
        if(root!=null){
        if(root.left!=null){
            helper(root.left,save);
        }
        if(root.right!=null){
            helper(root.right,save);
        }
        save.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> save = new ArrayList<>();
        helper(root,save);
        return save;
    }
}