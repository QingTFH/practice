package 链表_二叉树_回溯.二叉树;

public class a1379 {

    // 进行相同形式的遍历, 当original遇到target的时候, 返回cloned的节点

    // "同一棵树中，没有值相同的节点", 也可以直接找值

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null)
            return null;

        if (original == target)
            return cloned;

        TreeNode node = getTargetCopy(original.left, cloned.left, target);
        return node == null ? getTargetCopy(original.right, cloned.right, target) : node;
    }

}
