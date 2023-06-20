package main;

import manageBackG.background;
import manageBackG.tile;
import objects.AllObjects;
import objects.spawnObjects;


import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements Runnable {
   public int tileSize = 50;
    public int screenHeight = tileSize * 10;
   public int screenWidth = tileSize * 15;

   public int row = 10;
   public int col = 15;
   public String direction = "";
    public boolean collisionChecker;
    int countDiamond = 0;
    Thread gameThread;
    public AllObjects objects[] = new AllObjects[5];
    public spawnObjects s = new spawnObjects(this);
    Keys key = new Keys();
    music mus = new music();
    manageBackG.background back = new background(this);
    int posX = 300;
    int posY = 100;

    int displacement = 1;
    public text t = new text(this);
    public Game() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    public void addObjects() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        s.spawnD();
        s.spawnP();
        startMusic();
    }
    public void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null) {
            try {
                updatePosition();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            repaint();
            try {
                gameThread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updatePosition() throws IOException {
if(key.up == true || key.down == true || key.left == true || key.right == true) {
    if(key.up == true) {
        direction = "up";
    }
    else if(key.down == true) {
        direction = "down";

    }
    else if (key.left == true) {
        direction = "left";

    }
    else if (key.right == true) {
        direction = "right";

    }


    collisions c = new collisions(this);
    collisionChecker = c.check();
    int removeWhat = c.objCollisionCheck();
    removeObject(removeWhat);
    if(collisionChecker == false) {
        if(direction == "up") {
            posY = posY - displacement;
            if(posY <= 0) {
                posY = 0;
            }
        }
        else if (direction == "down") {
            posY = posY + displacement;
            if(posY >= screenHeight) {
                posY = screenHeight-10;
            }
        }
        else if (direction == "left") {
            posX = posX - displacement;
            if(posX <= 0) {
                posX = 0;
            }
        }
        else if (direction == "right") {
            posX = posX + displacement;
            if (posX >= screenWidth) {
                posX = screenWidth-15;
            }
        }
    }
}

    }

    int countPower = 0;
    public void removeObject(int removeWhatIndex) throws IOException {


        if(removeWhatIndex != 500 ) {

            if(removeWhatIndex == 0) {
                objects[removeWhatIndex] = null;
                countDiamond++;
                if(countDiamond == 5) {
                    t.gameOver = true;
                }
                if(countDiamond <5) {
                    s.spawnD();
                }
            }
            else if(removeWhatIndex == 1) {
                objects[removeWhatIndex] = null;
                countPower++;
                if(countPower <=3) {
                    s.spawnP();
                }
            }


        }

    }

    public void startMusic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        music.set();
        music.play();
        music.loop();
    }
    public void stopMusic() {
        music.stop();
    }

    public void paintComponent(Graphics g) {
        back.draw(g);// draw background tiles
        BufferedImage chara = null;
        try {
            chara = ImageIO.read(new File("C:\\TwoD\\src\\images\\c3.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < objects.length; i++) {
            if(objects[i] != null) {
                objects[i].draw(g, this);
            }
        }


        if(t.gameOver != true ) {
            t.clock+= (double)1/60; // draw gets called 60 times per second
        }

        g.drawImage(chara, posX, posY, tileSize, tileSize, null); // draw player

        t.draw(g); // draw text
        g.dispose();

    }
}
