package Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;
    public int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public void insertInOrder(int d) {
        if (d < data) {
            if (left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
        if(right != null) {
            right.parent = this;
        }
    }

    public TreeNode getLeft() {
        return left;
    }

    public int getData() {
        return data;
    }

    public TreeNode getRight() {
        return right;
    }

    private static TreeNode createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeftChild(createMinimalBST(arr, start, mid - 1));
        n.setRightChild(createMinimalBST(arr, mid + 1, end));
        return n;
    }

    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    public static void printTree(TreeNode root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.getData());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
