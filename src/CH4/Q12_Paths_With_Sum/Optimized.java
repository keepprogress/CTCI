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

    // 0  1  2  3  4  5  6  7  8
    // 10 5  1  2  -1 -1 7  1  2
    // 10 15 16 18 17 16 23 24 26

    // runningSumOf7 = 24
    // targetSum = 8
    // sum = 24 - 8 = 16
    // totalPaths = 2
    // pathCount = { 16: 2 }
    // 逐步放running sum 到 pathCount
    // 用 runningSum - targetSum 得到 sum
    // 用 sum 去 pathCount 找有沒有符合的
    // 有則取出來 = totalPaths
    // incrementHashTable邏輯 => 用來增加running sum 到 pathCount (現在的runnging sum 若存在則加上1，不存在則新增)
    // 此算法只算到當前有幾條路徑
    // 不會重算前面stack 算過的路徑數目
}
