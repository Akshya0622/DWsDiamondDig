package main;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        Game g = new Game();
        window.add(g);
        window.pack();
        window.setVisible(true);
        window.setTitle("DW's Diamond Dig");
        g.addObjects();
        g.start();



    }


}
