class Solution2 {
    fun connect(root: Node?): Node? {
        if(root == null) {
            return null
        }
        root.next = null
        setNext(root.left, root)
        setNext(root.right, root)
        return root
    }

    private fun setNext(node: Node?, parent: Node) {
        if(node == null) {
            return
        }
        if(node == parent.left) {
            node.next = parent.right
        } else if(node == parent.right) {
            node.next = parent.next?.left
        }
        setNext(node.left, node)
        setNext(node.right, node)
    }

}