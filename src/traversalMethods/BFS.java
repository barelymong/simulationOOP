package traversalMethods;

import java.util.*;

public class BFS {
    public static int[] traversal(Graph graph, int current, boolean[] discovered){

        Queue<Integer> queue = new ArrayDeque<>();

        int[] parent = new int[graph.adjList.size()];

        discovered[current] = true;
        Arrays.fill(parent, -1);

        queue.offer(current);

        while(!queue.isEmpty()){
            int length = 0;
            current = queue.poll();
            System.out.println("Вершина: " + current);

            for(int neighbor: graph.adjList.get(current)){ // рассмотрение списка смежности. current - узел, neighbor - соседи (элементы головного массива)
                if(!discovered[neighbor]){
                    discovered[neighbor] = true;
                    parent[neighbor] = current;
                    queue.offer(neighbor);

                }
            }

        }
        return parent;
    }
    public static List<Integer> reconstructPath(int start, int end, int[] parent) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);

        if (path.isEmpty() || path.get(0) != start) {
            return Collections.emptyList();
        }

        return path;
    }
}
