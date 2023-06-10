package CH4.Q8_First_Common_Ancestor;

import Library.TreeNode;

public class WithLInksToParentsBetterWorstCaseRuntime {

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* Check if either node is not in the tree, or if one covers the other. */
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    static TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }

        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
}
