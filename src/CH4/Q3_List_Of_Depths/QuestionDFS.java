package CH4.Q3_List_Of_Depths;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuestionDFS {

    public static void createLevelLinkedList(
            TreeNode root,
            ArrayList<LinkedList<TreeNode>> lists,
            int level
    ) {
       if(root == null) {
           return;
       }
       LinkedList<TreeNode> linkedLists = null;
       // lists does not contain node info
       if(level == lists.size()) {
           linkedLists = new LinkedList<>();
           /* Levels are always traversed in order. So, if this is the first time we've
            * visited level i, we must have seen level 0 through i - 1.
            * We can therefore safely add the level at the end. */
           lists.add(linkedLists);
       } else {
           linkedLists = lists.get(level);
       }
       linkedLists.add(root);
       createLevelLinkedList(root.left, lists, level +1);
       createLevelLinkedList(root.right, lists, level+1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for(LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.println("Link list at depth " + depth + ":");
            while(i.hasNext()) {
                System.out.println(" " + ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }

    /* Creates tree by mapping the array left to right, top to bottom. */
    public static TreeNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = (TreeNode) queue.element();
                if (r.left == null) {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length) {
                    done = true;
                }
            }
            return root;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
        printResult(list);
    }
}
