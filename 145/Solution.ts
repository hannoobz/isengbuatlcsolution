/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function helper(root:TreeNode | null, save: number[]){
    if(root!=null){
        if(root.left!=null){
            helper(root.left,save);
        }
        if(root.right!=null){
            helper(root.right,save);
        }
        save.push(root.val);
    }
}

function postorderTraversal(root: TreeNode | null): number[] {
    let save = new Array();
    helper(root,save);
    return save;
};