package CH4.Q11_Random_Node;

public class Tree {
    TreeNode root = null;

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode() {
        if (root == null) return null;

        int i = (int) (Math.random() * size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }
}
