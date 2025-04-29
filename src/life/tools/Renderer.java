package life.tools;


import life.entities.Entity;

public class Renderer {

    private static final int TERMINAL_HEIGHT = 15;

    public static void clearScreen() {

        for (int i = 0; i < TERMINAL_HEIGHT; i++) {
            System.out.println();
        }
    }

    public static void renderMap(GameMap map) {
        Renderer.clearScreen();
        for (int y = 0; y < map.getGlobalY(); y++) {
            System.out.println();
            for (int x = 0; x < map.getGlobalX(); x++) {
                Entity entity = map.getEntityAt(new Coordinate(x, y));
                System.out.print(entity.getImage());
            }
        }

    }
}