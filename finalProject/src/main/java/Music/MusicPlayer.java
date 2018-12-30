package Music;

import java.io.File;
import java.net.URISyntaxException;

import javafx.scene.media.AudioClip;

public class MusicPlayer {
    public void playMusic() throws URISyntaxException {
        AudioClip ac;
        ac = new AudioClip(getClass().getClassLoader().getResource("Music/huluwa.mp3").toURI().toString());
        ac.setCycleCount(1000);  //设置循环次数
        ac.play();   //开始播放
    }
}
