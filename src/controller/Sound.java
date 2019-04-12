package controller;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.Serializable;

public class Sound implements Serializable {

    // To call a sound use for example: playSound("sounds/hit.wav");

    //sound system
    public static void playSound(String soundFile) {
        File f = null;
        try {
            f = new File("./" + soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(f.toURI().toURL()));
            clip.start();
            Thread.sleep(150);

            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception ex) {
        }
    }

    //Background music
    public static void playSoundBattleScore(String soundFile) {
        try {
            File f = new File("./" + soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(f.toURI().toURL()));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
        }
    }
}
