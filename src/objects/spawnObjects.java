package objects;

import main.Game;

import java.io.IOException;
import java.util.Random;

public class spawnObjects {
    Game g;
    public spawnObjects(Game g) {
        this.g = g;
    }
    public void spawnD() throws IOException {
        g.objects[0] = new diamond();
        Random r = new Random();
        g.objects[0].objX = r.nextInt(g.screenWidth - (4 * g.tileSize)) + (2*g.tileSize);
        g.objects[0].objY =  r.nextInt(g.screenHeight - (4 * g.tileSize)) + (2*g.tileSize);




    }
    public void spawnP() throws IOException {
        g.objects[1] = new powerUp();
        Random r = new Random();
        g.objects[1].objX = r.nextInt(g.screenWidth - (4 * g.tileSize)) + (2*g.tileSize);
        g.objects[1].objY =  r.nextInt(g.screenHeight - (4 * g.tileSize)) + (2*g.tileSize);
    }
}
