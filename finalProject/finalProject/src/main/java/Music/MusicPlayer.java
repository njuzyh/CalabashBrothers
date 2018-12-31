package Music;

import java.io.File;
import java.net.URISyntaxException;

import Annotation.Author;
import javafx.scene.media.AudioClip;

@Author()
public class MusicPlayer {
    public void playMusic() throws URISyntaxException {
        AudioClip ac;
        ac = new AudioClip(getClass().getClassLoader().getResource("Music/huluwa.mp3").toURI().toString());
        ac.setCycleCount(1000);  //设置循环次数
        ac.play();   //开始播放
    }
}
