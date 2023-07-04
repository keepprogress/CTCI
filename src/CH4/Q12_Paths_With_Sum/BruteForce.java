package CH4.Q12_Paths_With_Sum;

import Library.TreeNode;

public class BruteForce {
    int countPathsWithSum(TreeNode root, int targetSum) {
        if (null == root) {
            return 0;
        }

        /* Count paths with sum starting from the root. */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        /* Try the nodes on the left and right. */
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    /* Returns the number of paths with this sum starting from this node. */
    int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (null == node) {
            return 0;
        }

        int totalPaths = 0;

        currentSum += node.data;
        if (currentSum == targetSum) {
            /* Found a path from the root. */
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }
}
