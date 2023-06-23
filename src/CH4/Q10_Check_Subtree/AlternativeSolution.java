package CH4.Q10_Check_Subtree;

import Library.TreeNode;

public class AlternativeSolution {
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true; // The empty tree is a subtree of every tree.
        return subTree(t1, t2);
    }

    public static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) return false; // big tree empty & subtree still not found.
        if (r1.data == r2.data) {
            if (matchTree(r1, r2)) return true;
        }
        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    public static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r2 == null && r1 == null) return true; // nothing left in the subtree
        if (r1 == null || r2 == null) return false; // big tree empty & subtree still not found
        if (r1.data != r2.data) return false; // data doesn't match
        return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
    }

    // Time complexity: O(n + km) where n is the number of nodes in T1 and m is the number of nodes in T2
    // Space complexity: O(log(n) + log(m))
    // The worst case time complexity is O(n * m)
    // The worst case space complexity is O(log(n) + log(m))
    // A slightly tighter bound on the runtime would be O(n + km) where k is the number of occurrences of T2's root in T1.
    // This is because each time we find a match, we might have to spend O(m) additional nodes to see if the trees match.
    // In the worst case, we might traverse the entire subtree of T1 for each node in T1, giving us O(n * m) runtime.
    // A slightly tighter bound on the runtime, as explained earlier, would be O(n + km) where k is the number of occurrences of T2's root in T1.
    // Let's suppose the node data for T1 and T2 were random numbers picked beteween 0 and p.
    // The value of k would be approximately n/p.
    // Why? Because each of n nodes in T1 has a 1/p chance of matching T2's root, so approximately n/p nodes will match.
    // Let's say p = 1000, n = 1000000 and m = 100. We should do somewhere around 1,100,000 node checks (1100000 = 1000000+ (100*1000000/1000)).
}
