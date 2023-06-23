package CH4.Q10_Check_Subtree;

import Library.TreeNode;

public class Solution {
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    public static void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }

        sb.append(node.data + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

    // use pre-order traversal to get the string of the tree
    // trees with different structure could still have the same pre-order traversal
    //    3     3
    //   /       \
    //  4         4

    // so we use x to represent null node then we can distinguish the two trees
    //    3     3
    //   / \   / \
    //  4   x x   4
    // one is {3, 4, x} the other one is {3, x, 4}
}
