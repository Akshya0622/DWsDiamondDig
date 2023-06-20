package main;

import java.awt.*;
import java.text.DecimalFormat;

public class text {
    Game g;
    public boolean gameOver;
    double clock;
    DecimalFormat df = new DecimalFormat("#0.00");
    public text(Game g) {
        this.g = g;

    }
    public void draw (Graphics gr) {
        if (gameOver == true) {

            gr.setFont(new Font("Arial", Font.BOLD, 35));
            gr.setColor(Color.RED);
            gr.drawString("YOU FOUND ALL THE DIAMONDS!! " , 80, (g.screenHeight/2) - 15);
            gr.drawString(df.format(clock), 345, (g.screenHeight/2) + 100);

        }
        else {

            gr.setFont(new Font("Arial", Font.BOLD, 20));
            gr.setColor(Color.WHITE);
            gr.drawString("Diamonds: " + g.countDiamond, 50, 40);
            gr.drawString(df.format(clock), 650, 40);
        }
    }
}
