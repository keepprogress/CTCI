package CH4.Q5_Validate_BST;

import Library.TreeNode;

public class InOrderTraversal {
    Integer last_printed = null;

    boolean checkBST(TreeNode node) {
        if(node == null) return true;

        // check left
        if(!checkBST(node.left)) return false;

        // after the most left, check current and print last element
        if(last_printed != null && node.data < last_printed) return false;

        last_printed = node.data;

        // check right
        if(!checkBST(node.right)) return false;

        return true;
    }
}
