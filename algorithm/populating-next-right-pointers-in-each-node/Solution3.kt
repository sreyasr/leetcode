class Solution3 {
    private val list: java.util.ArrayList<Pair<Node?, Node>> = ArrayList()
    fun connect(root: Node?): Node? {
        if(root == null) {
            return null
        }
        root.next = null
        addItems(root)
        var i = 0
        while(i < list.size) {
            val (item, parent) = list[i]
            i++
            if(item == null) {
                continue
            }
            if(item == parent.left) {
                item.next = parent.right
            } else if(item == parent.right) {
                item.next = parent.next?.left
            }
            addItems(item)
        }
        return root
    }

    private fun addItems(node: Node) {
        list.add(node.left to node)
        list.add(node.right to node)
    }
}