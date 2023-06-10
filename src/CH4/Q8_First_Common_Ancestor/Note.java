package CH4.Q8_First_Common_Ancestor;

public class Note {
    // First Come up with a solution is recursive function
    // one function will check if specific node is left descendent of root node
    // FirstCommonAncestor function will have 3 parameters (TreeNode root, TreeNode p, TreeNode q)
    // FirstCommonAncestor will first check if root is a tree if only one node then return null
    // then the FirstCommanAncestor will check if p and q are in the same side of root
    // if not then return root
    // Because it shows the root is the first common ancestor, they are in different side of root
    // if they are in the same side then we need to check the side they are in
    // if both p and q are in left side then we need to call FirstCommonAncestor(root.left, p, q)
    // if both p and q are in right side then we need to call FirstCommonAncestor(root.right, p, q)
    // in the end of Function FirstCommonAncestor we need to return the result of the recursive function
    // return FirstCommonAncestor(root.left, p, q) or FirstCommonAncestor(root.right, p, q)

    // this solution map to the Solution #3 in the book.
}
