package traversalMethods;

import life.tools.Coordinate;
import life.entities.Entity;
import life.tools.GameMap;

import java.util.*;

public class BFSgrid {
    static int[] dr = {-1, +1, 0, 0};
    static int[] dc = {0, 0, +1, -1};

    public static HashMap<Coordinate, Coordinate> traversal(GameMap gameMap, Coordinate currentCoordinate, Class<? extends Entity> targetType){ // как третий параметр добавить искомый объект
        HashMap<Coordinate, Coordinate> parent = new HashMap<>();
        Queue<Coordinate> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[gameMap.getGlobalY()][gameMap.getGlobalX()];

        visited[currentCoordinate.getY()][currentCoordinate.getX()] = true;
        //currentCoordinate - координата от которой в данный момент рассматриваются смежные координаты
        //adjCoordinate - смежные координаты
        Coordinate targetCoordinate = null;
        queue.offer(currentCoordinate);

        while(!queue.isEmpty()){
            currentCoordinate = queue.poll();

            for(int i = 0; i < 4; i++){
                int adjX = currentCoordinate.getX() + dc[i];
                int adjY = currentCoordinate.getY() + dr[i];
                Coordinate adjCoordinate = new Coordinate(adjX, adjY);

                if(adjCoordinate.getX() < 0 || adjCoordinate.getY() < 0){
                    continue;
                }
                if(adjCoordinate.getX() >= gameMap.getGlobalX() || adjCoordinate.getY() >= gameMap.getGlobalY()){
                    continue;
                }

                if(visited[adjCoordinate.getY()][adjCoordinate.getX()]){
                    continue;
                }

                if(!gameMap.getEntityAt(adjCoordinate).isCrossAbility()){
                    continue;
                }


                Entity adjEntity = gameMap.getEntityAt(adjCoordinate);
                visited[adjY][adjX] = true;
                queue.offer(adjCoordinate);

                parent.put(adjCoordinate, currentCoordinate);
                if (targetType.isInstance(adjEntity)) {
                    targetCoordinate = adjCoordinate;

                    Coordinate flag = new Coordinate(-1, -1);
                    parent.put(flag, targetCoordinate);
                    queue.clear();
                    break;
                }

            }


            // будущее исключение если не найдено то что нужно
        }


            if(targetCoordinate != null){
                return parent;
            }

            else{
                return new HashMap<>();
            }

    }

    public static Deque<Coordinate> reconstructPath(Coordinate start, HashMap<Coordinate, Coordinate> parent) {
        Deque<Coordinate> path = new ArrayDeque<>();
        Coordinate end = parent.get(new Coordinate(-1, -1));
        Coordinate current = end;
        if (!parent.containsKey(end)) {
            System.out.println("Path0: " + path);

        }

        while (current != null) {
            path.push(current);
            current = parent.get(current);
        }


//        if (path.isEmpty()) {
//            System.out.println("Path1: " + path);
//            return Collections.emptyList();
//        }
        path.pop();
        return path;
    }

    public static Deque<Coordinate> createPath(GameMap gameMap, Coordinate entityCoordinate, Class<? extends Entity> targetType){
        HashMap<Coordinate, Coordinate> parent = BFSgrid.traversal(gameMap, entityCoordinate, targetType);
        if(parent.isEmpty()){
            return new ArrayDeque<>();
        }
        return reconstructPath(entityCoordinate, parent);
    }
}
