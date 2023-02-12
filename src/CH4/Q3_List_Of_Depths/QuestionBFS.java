package CH4.Q3_List_Of_Depths;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class QuestionBFS {

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList();
        if(root != null) {
            current.add(root);
        }

        while(current.size() > 0) {
            result.add(current); // add previous level
            LinkedList<TreeNode> parents = current; // Go to next level
            current = new LinkedList();
            for(TreeNode parent : parents) {
                if(parent.right != null) {
                    current.add(parent.right);
                }
                if(parent.left != null) {
                    current.add(parent.left);
                }
            }
        }
        return result;
    }
}
