package main;

import objects.AllObjects;

import java.awt.*;

public class collisions {

    Game g;

    public collisions(Game g) {
        this.g = g;

    }

    public boolean check() {

        int locationRow = g.posY/g.tileSize;
        int locationCol = g.posX/g.tileSize;
        int tileValue;
        int tileValue2;
        int tileValue3;
        int tileValue4;
        int locationRowUpdated;
        int locationColUpdated;
        if(g.direction == "up") {
            locationRowUpdated = (g.posY - g.displacement)/ g.tileSize; // where is the player gonna be after moving
            tileValue = g.back.pickTiles[locationRowUpdated][locationCol];
            tileValue2 = g.back.pickTiles[locationRowUpdated][locationCol+1];
            if(g.back.myTiles[tileValue].collision == true || g.back.myTiles[tileValue2].collision == true ){
                g.collisionChecker = true;
            }
            else {
                g.collisionChecker = false;
            }
        }
        if(g.direction == "down") {
            locationRowUpdated =  (g.posY + g.displacement)/ g.tileSize;
            tileValue3 = g.back.pickTiles[locationRowUpdated+1][locationCol];
            tileValue4 = g.back.pickTiles[locationRowUpdated+1][locationCol+1];
            if(g.back.myTiles[tileValue3].collision == true || g.back.myTiles[tileValue4].collision == true){
                g.collisionChecker = true;
            }
            else {
                g.collisionChecker = false;
            }
        }
        if(g.direction == "left") {
            locationColUpdated =  (g.posX - g.displacement)/ g.tileSize;
            tileValue = g.back.pickTiles[locationRow][locationColUpdated];
            tileValue3 = g.back.pickTiles[locationRow+1][locationColUpdated];

            if(g.back.myTiles[tileValue].collision == true ||  g.back.myTiles[tileValue3].collision == true){
                g.collisionChecker = true;
            }
            else {
                g.collisionChecker = false;
            }
        }
        if(g.direction == "right") {
            locationColUpdated = (g.posX + g.displacement)/ g.tileSize;
            tileValue2 = g.back.pickTiles[locationRow][locationColUpdated+1];
            tileValue4 = g.back.pickTiles[locationRow+1][locationColUpdated+1];
            if(g.back.myTiles[tileValue2].collision == true || g.back.myTiles[tileValue4].collision == true){
                g.collisionChecker = true;
            }
            else {
                g.collisionChecker = false;
            }

        }
        return g.collisionChecker;
    }

    public int objCollisionCheck() {
        int removeWhat = 500;
        Rectangle objIntersect = new Rectangle();
        Rectangle playerIntersect = new Rectangle();
        int size = AllObjects.objSize;
        for(int i = 0; i < g.objects.length; i++) {

            if(g.objects[i] != null) {


                objIntersect.x = g.objects[i].objX;
                objIntersect.y = g.objects[i].objY;
                objIntersect.width = size;
                objIntersect.height = size;
                playerIntersect.x = g.posX + 0;
                playerIntersect.y = g.posY + 0;
                playerIntersect.width = g.tileSize;
                playerIntersect.height = g.tileSize;

                if(g.direction == "up") {
                    playerIntersect.y -= g.displacement;
                    if(playerIntersect.intersects(objIntersect)) {
                        removeWhat = i;
                        if(i == 1) {
                            g.displacement+=2;
                        }
                    }
                }
                else if(g.direction == "down") {

                    playerIntersect.y += g.displacement;
                    if(playerIntersect.intersects(objIntersect)) {
                        removeWhat = i;
                        if(i == 1) {
                            g.displacement+=2;
                        }
                    }
                }
                else if(g.direction == "left") {
                    playerIntersect.x -= g.displacement;
                    if(playerIntersect.intersects(objIntersect)) {
                        removeWhat = i;
                        if(i == 1) {
                            g.displacement+=2;
                        }
                    }
                }
                else if (g.direction == "right") {
                    playerIntersect.x += g.displacement;
                    if(playerIntersect.intersects(objIntersect)) {
                        removeWhat = i;
                        if(i == 1) {
                            g.displacement+=2;
                        }
                    }
                }
            }

            }


        return removeWhat;
    }
}
