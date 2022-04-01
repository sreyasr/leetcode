import java.util.*
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
class Solution {
    fun connect(root: Node?): Node? {
        val queue: Queue<Node?> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val item = queue.poll() ?: continue
            val nextItem = queue.peek()
            item.next = nextItem
            queue.add(item.left)
            queue.add(item.right)
            if(item.next == null) {
                queue.add(null)
            }
        }
        return root
    }
}