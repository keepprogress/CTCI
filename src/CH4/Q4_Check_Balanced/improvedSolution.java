package CH4.Q4_Check_Balanced;

import Library.TreeNode;

public class improvedSolution {
    int checkHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = checkHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Found Error

        int rightHeight = checkHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Found Error

        int difHeight = leftHeight - rightHeight;

        if(Math.abs(difHeight) > 1) {
            return Integer.MIN_VALUE; // Found Error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) +1;
        }
    }

    boolean isBalanced(TreeNode node) {
        return checkHeight(node) != Integer.MIN_VALUE;
    }
}
