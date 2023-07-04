package CH4.Q12_Paths_With_Sum;

import Library.TreeNode;

import java.util.HashMap;

public class Optimized {
    int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (null == node) {
            return 0;
        }

        /* Count paths with sum ending at the current node. */
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        /* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
        if (runningSum == targetSum) {
            totalPaths++;
        }

        /* Increment pathCount, recurse, then decrement pathCount. */
        incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount

        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) { // Remove when zero to reduce space usage
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
