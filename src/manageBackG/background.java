package manageBackG;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class background {
    Game g;
    public tile[] myTiles;
    public int[][] pickTiles = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,2,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,2,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,2,0,0,0,0,0,0,1},
            {1,0,2,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };


    public background(Game g) throws IOException {
        this.g = g;
        myTiles = new tile[3];
        getTiles();
    }
    public void getTiles() throws IOException {


        myTiles[0] = new tile();
        BufferedImage b1 = ImageIO.read(new File("C:\\TwoD\\src\\images\\sand.png"));
        myTiles[0].image = b1;
        myTiles[0].collision = false;
        myTiles[1] = new tile();
        BufferedImage b2 = ImageIO.read(new File("C:\\TwoD\\src\\images\\water.png"));
        myTiles[1].image = b2;
        myTiles[1].collision = true;
        myTiles[2] = new tile();
        BufferedImage b3 = ImageIO.read(new File("C:\\TwoD\\src\\images\\tree.png"));
        myTiles[2].image = b3;
        myTiles[2].collision = true;
    }
    public void draw(Graphics gr) {


        int px = 0;
        int py = 0;

        for (int r = 0; r < g.row; r++) {
            for(int c = 0 ; c < g.col; c++) {
                int tileA = pickTiles[r][c];
                gr.drawImage(myTiles[tileA].image, px, py, g.tileSize, g.tileSize, null );
                px = px + g.tileSize;
                if(c == g.col - 1) {
                    px = 0;
                    py = py + g.tileSize;
                }
            }
        }

    }
}
