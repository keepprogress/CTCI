package CH4.Q9_BST_Sequence;

import Library.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public static ArrayList<LinkedList> allSequence(TreeNode node) {
        ArrayList<LinkedList> result = new ArrayList<>();

        if (null == node) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();

        // 因為遞迴最後一個stack 要回 root, 所以要先把root加入prefix
        // 待遞迴結束後 prefix 會是 root node.
        prefix.add(node.data);

        // Recurse on left and right subtrees.
        ArrayList<LinkedList> leftSeq = allSequence(node.left);
        ArrayList<LinkedList> rightSeq = allSequence(node.right);

        // Weave together each list from the left and right sides.
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    static void weaveLists(
            LinkedList first,
            LinkedList second,
            ArrayList<LinkedList> results,
            LinkedList<Integer> prefix
    ) {
        // One list is empty. Add remainder to [a cloned] prefix and store result.
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        // Recurse with head of first added to the prefix. Removing the head will damage first,
        // so we'll need to put it back where we found it afterwards.
        int headFirst = (int) first.removeFirst();
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        // Do the same thing with second, damaging and then restoring the list.
        int headSecond = (int) second.removeFirst();
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
