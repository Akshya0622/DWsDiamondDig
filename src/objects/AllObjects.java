package objects;

import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AllObjects {
    public BufferedImage image;
    public String objName;
    public boolean collision;
    public int objX;
    public int objY;
    public static int objSize = 50;

    public void draw(Graphics gr, Game g) {

        gr.drawImage(image, objX, objY, objSize, objSize, null);
    }
}
