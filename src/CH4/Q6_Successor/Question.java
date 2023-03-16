package CH4.Q6_Successor;

import Library.TreeNode;

public class Question {
    public static TreeNode inorderSucc(TreeNode n) {
        if(n == null) {
            return null;
        }
        if(n.parent == null || n.right != null) {
            return leftMostChild(n.right);
        } else {
            // go up until we're on left instead of right
            while(n.parent != null && n.parent.left != n) {
                n = n.parent;
            }
            return n.parent;
        }
    }

    public static TreeNode leftMostChild(TreeNode n) {
        if(n.left == null) {
            return n;
        } else {
            return leftMostChild(n.left);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode.printTree(root);
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSucc(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }
}
