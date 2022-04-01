import java.util.LinkedList
import java.util.Queue

class Solution2 {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        val queue: Queue<Pair<TreeNode, TreeNode>>  = LinkedList()
        if(root1 == null) {
            return root2
        } else if(root2 == null) {
            return root1
        }
        queue.add(root1 to root2)
        while(queue.isNotEmpty()) {
            val (r1, r2) =  queue.poll()
            r1.`val` = r1.`val` + r2.`val`
            if(r1.left == null) {
                r1.left = r2.left
            } else if(r2.left != null) {
                queue.add((r1.left to r2.left) as Pair<TreeNode, TreeNode>?)
            }
            if(r1.right == null) {
                r1.right = r2.right
            } else if(r2.right != null) {
                queue.add((r1.right to r2.right) as Pair<TreeNode, TreeNode>?)
            }
        }
        return root1
    }
}

fun main() {
    val a = TreeNode(1)
    val b = TreeNode(1)
    b.right = TreeNode(2)
    Solution2().mergeTrees(a, b)
}

