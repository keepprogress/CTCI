package CH4.Q2_Minimal_Tree;

import Library.TreeNode;

import java.util.List;

public class Question {

    public TreeNode createMinimalTree(int[] numbers) {
        return createMinimalTreeBST(numbers, 0, numbers.length -1);
    }

    public TreeNode createMinimalTreeBST(int[] arr, int startIndex, int endIndex) {
        if(endIndex < startIndex) {
            return null;
        }
        int midIndex = (startIndex + endIndex)/2;
        TreeNode node = new TreeNode(arr[midIndex]);
        node.left = createMinimalTreeBST(arr, startIndex, midIndex -1);
        node.right = createMinimalTreeBST(arr, midIndex+1, endIndex);
        return node;
    }
}
