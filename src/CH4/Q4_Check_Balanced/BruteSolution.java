package CH4.Q4_Check_Balanced;

import Library.TreeNode;

public class BruteSolution {
    int getHeight(TreeNode node) {
        if (node == null) {
            // if only have two level node. then the  height must be 1 = 1+1-1
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) +1;
    }

    boolean isBalanced(TreeNode node) {
        if(node == null) {
            return true;
        }

        int differNum = getHeight(node.left) - getHeight(node.right);
        // according to the description of question when differNum > 1 return false;
        if(differNum > 1) {
            return false;
        }
        return isBalanced(node.right) && isBalanced(node.left);
    }
}
