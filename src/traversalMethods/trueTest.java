package traversalMethods;

import java.util.Arrays;
import java.util.List;

public class trueTest {
    public static void main(String[] args) {


        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
                new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
                new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
        );

        int n = 15;

        Graph graph = new Graph(edges, n);

        boolean[] discovered = new boolean[n];
        int start = 1;
        int end = 11;

        int[] parent = BFS.traversal(graph, start, discovered);

        List<Integer> path = BFS.reconstructPath(start, end, parent);

        System.out.println(path);
    }
}

