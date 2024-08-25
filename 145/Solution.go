/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func helper(root *TreeNode,save *[]int) {
    if(root!=nil){
        if(root.Left!=nil){
            helper(root.Left,save);
        }
        if(root.Right!=nil){
            helper(root.Right,save);
        }
        *save = append(*save,root.Val);
    }
}
func postorderTraversal(root *TreeNode) []int {
    save := []int{}
    helper(root,&save);
    return save;
}