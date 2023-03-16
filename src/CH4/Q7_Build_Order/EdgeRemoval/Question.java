package CH4.Q7_Build_Order.EdgeRemoval;

import java.util.ArrayList;

public class Question {
    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for(String project : projects) {
            graph.getOrCreateNode(project);
        }

        for(String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        // dependency 前面
        // children 自己移除後解除限制的Node
        for(Project project : projects) {
            if(project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    public static Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);
        // 2
        // order = [1,2,3]

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            /**
             * We have a circular dependency since there are no remaining projects with
             * zero dependencies
             **/
            if(current == null) {
                return null;
            }

            /** Remove myself as a dependency **/
            ArrayList<Project> children = current.getChildren();
            for(Project child : children) {
                child.decrementDependencies();
            }

            endOfList = addNonDependent(order, children, endOfList);

            toBeProcessed++;
        }

        return order;
    }

    public static String[] convertToStringList(Project[] projects) {
        String[] buildOrder = new String[projects.length];
        for (int i = 0; i < projects.length; i++) {
            buildOrder[i] = projects[i].getName();
        }
        return buildOrder;
    }

    public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        Project[] buildOrder = findBuildOrder(projects, dependencies);
        if (buildOrder == null) return null;
        String[] buildOrderString = convertToStringList(buildOrder);
        return buildOrderString;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j" ,"1", "2"};
        String[][] dependencies = {
                {"1", "2"},
                {"2", "1"},
                {"2", "e"},
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }
}
