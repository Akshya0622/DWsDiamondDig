package main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class music {
    static Clip clip;
    static File f;

    public music() {
        f = new File("C:\\TwoD\\src\\images\\BeepBox-Song - Copy.wav");
    }
    public static void set() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

            AudioInputStream a = AudioSystem.getAudioInputStream(f.toURL());
            clip = AudioSystem.getClip();
            clip.open(a);


    }
    public static void play() {
        clip.start();
    }
    public static void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void stop() {
        clip.stop();
    }
}

