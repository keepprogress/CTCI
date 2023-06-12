package CH4.Q8_First_Common_Ancestor;

import Library.TreeNode;

public class OptimizedWithoutLinksToParents {
    public static class Result {
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }
        Result x = commonAncestorHelper(root.left, p, q);
        if (x.isAncestor) { // Found common ancestor
            return x;
        }
        Result y = commonAncestorHelper(root.right, p, q);
        if (y.isAncestor) { // Found common ancestor
            return y;
        }
        if (x.node != null && y.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            /* If we're currently at p or q, and we also found one of those nodes in a subtree, then this is truly an ancestor and the flag should be true. */
            boolean isAncestor = x.node != null || y.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(x.node != null ? x.node : y.node, false);
        }
    }
}
