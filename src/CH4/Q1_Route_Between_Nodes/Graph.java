package CH4.Q1_Route_Between_Nodes;

public class Graph {
    public static int MAX_VERTICES = 6;
    private Node vertices[];
    public int count;
    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count] = x;
            count ++;
        } else {
            System.out.println("Graph full");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}
