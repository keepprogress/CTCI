package CH4.Q5_Validate_BST;

import Library.TreeNode;

public class MinMaxSolution {
    boolean checkBST(TreeNode node) {
        return checkBST(node, null, null);
    }

    boolean checkBST(TreeNode node, Integer min, Integer max) {
        // check left < min
        if(node == null) return true;

        if((min != null && node.data < min) || (max != null && node.data > max)) {
            return false;
        }

        if(!checkBST(node.left, min, node.data)) return false;

        if(!checkBST(node.right, node.data, max)) return false;

        return true;
    }
}
