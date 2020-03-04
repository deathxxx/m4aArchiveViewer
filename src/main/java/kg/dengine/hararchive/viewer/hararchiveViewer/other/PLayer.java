package kg.dengine.hararchive.viewer.hararchiveViewer.other;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PLayer {
    public void test() {
        String name = "/home/dex/Music/28-vandera-is_it_real_(merce_remix).m4a";
        Media song = new Media(name);
        MediaPlayer player = new MediaPlayer(song);
        player.play();
    }
}
