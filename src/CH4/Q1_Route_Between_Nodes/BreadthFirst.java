package CH4.Q1_Route_Between_Nodes;

import java.util.LinkedList;

public class BreadthFirst {
    boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        //operate as Queue
        LinkedList<Node> q = new LinkedList<>();

        // mark as Unvisited
        for(Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }

        start.state = State.Unvisited;
        q.add(start);
        while(!q.isEmpty()) {
            Node r = q.removeFirst();
            if(null != r) {
                for(Node inside : r.getAdjacent()) {
                    if(inside == end) {
                        return true;
                    }
                    if(inside.state == State.Unvisited) {
                            inside.state = State.Visiting;q.add(inside);
                    }
                }
            }
            r.state= State.Visited;
        }
        return false;
    }
}
