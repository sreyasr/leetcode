// https://leetcode.com/problems/merge-two-binary-trees/
class Solution {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        root1.hashCode()
        if(root1 == null) {
            return root2
        }
        if(root2 == null) {
            return root1
        }
        val head = TreeNode(root1.`val` + root2.`val`)
        val left = mergeTrees(root1.left, root2.left)
        val right = mergeTrees(root1.right, root2.right)
        head.left = left
        head.right = right
        return head
    }
}