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

//在给定的代码中，函数commonAncestorHelper用于在给定的二叉树root中查找节点p和节点q的最近公共祖先。该函数是通过递归的方式进行搜索的。
//
//        在递归的过程中，首先检查当前节点root是否为p和q中的一个。如果是，表示当前节点就是最近公共祖先，将isAncestor标记为true并返回。
//
//        然后，递归调用commonAncestorHelper函数来搜索左子树和右子树。如果在左子树中找到了最近公共祖先（x.isAncestor为true），则直接返回该结果，因为最近公共祖先已经找到了。
//
//        接着，在右子树中搜索，如果在右子树中找到了最近公共祖先（y.isAncestor为true），同样直接返回该结果，因为最近公共祖先已经找到了。
//
//        如果x.node和y.node都不为空，说明p和q分别位于当前节点的左子树和右子树中，那么当前节点就是最近公共祖先，将isAncestor标记为true并返回。
//
//        如果当前节点既不是p也不是q，但是在左子树或右子树中找到了p或q中的一个，说明当前节点是真正的祖先，并且isAncestor应该标记为true。
//
//        最后，如果以上条件都不满足，说明在当前子树中没有找到p和q，那么返回非空的x.node或y.node（如果其中一个为空，则返回另一个），并将isAncestor标记为false。
//
//        因此，在代码中的if (y.isAncestor)语句中，如果在右子树中找到了最近公共祖先，那么y.isAncestor将为true，表示已经找到了最近公共祖先，所以直接返回结果y。这样就可以确保在找到最近公共祖先后，递归的过程会立即停止，避免不必要的继续搜索。

//  如果當前節點 root 正在 q or q 那麼 同時 不滿足 x.node != null && y.node != null
//  則代表有可能 root 是 p or q 之一，且另一個節點在 root的左邊或右邊 的子樹中
