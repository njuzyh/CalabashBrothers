package GUI;

import Creature.Creature;
import Field.BattleField;
import Formation.*;

import Music.MusicPlayer;
import XML.FileReader;
import XML.FileWriter;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import org.dom4j.DocumentException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CalabashWorldController implements Initializable {
    private Changshe cs = new Changshe();
    private Chonge ce = new Chonge();
    private Fangyuan fy = new Fangyuan();
    private Fengshi fs = new Fengshi();
    private Heyi hy = new Heyi();
    private Yanxing yx = new Yanxing();
    private Yanyue yy = new Yanyue();
    private Yulin yl = new Yulin();
    private BattleField newBattle;
    private GraphicsContext gc;
    private GraphicsContext bulletgc;
    private FileWriter recordWriter;
    private FileReader recordReader;
    private Timeline timeline;
    private AnimationTimer timer;
    private int currentRoundNum;
    private boolean inBattle;
    private String winner;
    private int recordNum = 1;
    private File recordFile;
    private MusicPlayer player;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MenuItem OpenFile = new MenuItem();
    @FXML
    private MenuItem Restart = new MenuItem();
    @FXML
    private MenuItem SaveLog = new MenuItem();
    @FXML
    private MenuItem About = new MenuItem();
    @FXML
    private MenuItem CalabashFormationChangShe = new MenuItem();
    @FXML
    private MenuItem CalabashFormationChongE = new MenuItem();
    @FXML
    private MenuItem CalabashFormationFangYuan = new MenuItem();
    @FXML
    private MenuItem CalabashFormationFengShi = new MenuItem();
    @FXML
    private MenuItem CalabashFormationHeYi = new MenuItem();
    @FXML
    private MenuItem CalabashFormationYanXing = new MenuItem();
    @FXML
    private MenuItem CalabashFormationYanYue = new MenuItem();
    @FXML
    private MenuItem CalabashFormationYuLin = new MenuItem();
    @FXML
    private MenuItem MonsterFormationChangShe = new MenuItem();
    @FXML
    private MenuItem MonsterFormationChongE = new MenuItem();
    @FXML
    private MenuItem MonsterFormationFangYuan = new MenuItem();
    @FXML
    private MenuItem MonsterFormationFengShi = new MenuItem();
    @FXML
    private MenuItem MonsterFormationHeYi = new MenuItem();
    @FXML
    private MenuItem MonsterFormationYanXing = new MenuItem();
    @FXML
    private MenuItem MonsterFormationYanYue = new MenuItem();
    @FXML
    private MenuItem MonsterFormationYuLin = new MenuItem();
    @FXML
    private GridPane gridPane;
    @FXML
    private Canvas canvas = new Canvas();
    @FXML
    private Canvas BulletCanvas = new Canvas();
    @FXML
    public void MonsterChangShe()
    {
        displayFormation(cs, 0);
    }
    @FXML
    public void MonsterChongE()
    {
        displayFormation(ce, 0);
    }
    @FXML
    public void MonsterFangYuan()
    {
        displayFormation(fy, 0);
    }
    @FXML
    public void MonsterFengShi()
    {
        displayFormation(fs, 0);
    }
    @FXML
    public void MonsterHeYi()
    {
        displayFormation(hy, 0);
    }
    @FXML
    public void MonsterYanXing()
    {
        displayFormation(yx, 0);
    }
    @FXML
    public void MonsterYanYue()
    {
        displayFormation(yy, 0);
    }
    @FXML
    public void MonsterYuLin()
    {
        displayFormation(yl, 0);
    }
    @FXML
    public void HeroChangShe()
    {
        displayFormation(cs, 1);
    }
    @FXML
    public void HeroChongE()
    {
        displayFormation(ce, 1);
    }
    @FXML
    public void HeroFangYuan()
    {
        displayFormation(fy, 1);
    }
    @FXML
    public void HeroFengShi()
    {
        displayFormation(fs, 1);
    }
    @FXML
    public void HeroHeYi()
    {
        displayFormation(hy, 1);
    }
    @FXML
    public void HeroYanXing()
    {
        displayFormation(yx, 1);
    }
    @FXML
    public void HeroYanYue()
    {
        displayFormation(yy, 1);
    }
    @FXML
    public void HeroYuLin()
    {
        displayFormation(yl, 1);
    }

    @FXML
    public void openlog() throws DocumentException, InterruptedException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open GameLog File");
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        recordReader = new FileReader(file);
        System.out.println("读取文件获取回合数" + recordReader.getRoundNum());
        Replay();
    }

    @FXML
    public void savelog(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存记录");
        FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(fileExtensions);
        // 将初始目录设置为项目当前路径
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try {
                recordFile = file;
                recordWriter = new FileWriter(recordFile);
                recordNum++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void about(){
        Alert information = new Alert(Alert.AlertType.INFORMATION,"开发者：NJUZYH ");
        information.setTitle("版本信息"); //设置标题，不设置默认标题为本地语言的information
        information.setHeaderText("葫芦娃救爷爷V1.0"); //设置头标题，默认标题为本地语言的information
        information.showAndWait(); //显示弹窗，同时后续代码等挂起
    }

    @FXML
    public void restart() {
        newBattle.cleanBattle();
        initBattle();
    }

    @FXML
    public void StartGame()
    {
        savelog();
        inBattle = true;
        new Thread(new Battle(newBattle, inBattle, recordWriter, this)).start();
    }

    @FXML
    public void HandleKeyPressed(KeyEvent event) throws DocumentException, InterruptedException {
        System.out.println(event.getCode());
        switch (event.getCode()) {
            case LEFT:
                break;
            case RIGHT:
                break;
            case UP:
                break;
            case DOWN:
                break;
            case SPACE:
                System.out.print("start");
                StartGame();
                break;
            case L:
                System.out.print("load");
                openlog();
                break;
        }
    }

    @FXML private void canvasDragDetect(MouseEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        x = x / 30;
        y = y / 30;
        System.out.print(x);
    }

    public void BattleWin()
    {
        winner = newBattle.getWinner().isJustice() ? "葫芦娃" : "妖精";
        Alert information = new Alert(Alert.AlertType.INFORMATION,"  胜利方：" + winner);
        information.setTitle("Win!"); //设置标题，不设置默认标题为本地语言的information
        information.setHeaderText("Congratulation!"); //设置头标题，默认标题为本地语言的information
        information.showAndWait(); //显示弹窗，同时后续代码等挂起
        inBattle = false;
    }

    public void Replay()
    {
        newBattle = new BattleField(gc, bulletgc);
        newBattle.startReplay(recordReader);
        int roundNum = recordReader.getRoundNum();
        currentRoundNum = 1;
        Timeline timeline = new Timeline();
        timeline.setCycleCount(roundNum);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100),
                arg0 -> {
                    newBattle.showRound(recordReader, currentRoundNum);
                    currentRoundNum++;
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        timeline.setOnFinished(event -> replayFinished());
    }

    public void replayFinished()
    {
        newBattle.findWinner();
        winner = newBattle.getWinner().isJustice() ? "葫芦娃" : "妖精";
        Alert information = new Alert(Alert.AlertType.INFORMATION,"  胜利方：" + winner);
        information.setTitle("回放"); //设置标题，不设置默认标题为本地语言的information
        information.setHeaderText("回放结束!"); //设置头标题，默认标题为本地语言的information
        information.setOnHidden(event -> System.out.println("Replay finished!"));
        information.show();
    }

    public void initGraphicsContext()
    {
        gc = canvas.getGraphicsContext2D();
        bulletgc = BulletCanvas.getGraphicsContext2D();
    }

    public void initBattle()
    {
        newBattle = new BattleField(gc, bulletgc);
        newBattle.displayGUIBattle();
        newBattle.displayBattle();
    }

    public void displayFormation(Formation formation, int direction)
    {
        newBattle.cleanBattle();
        newBattle.updateBattle(formation, direction);
        newBattle.displayGUIBattle();
        newBattle.displayBattle();
    }

    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        System.out.print("huluwa");;
        initGraphicsContext();
        initBattle();
        player = new MusicPlayer();
        try {
            player.playMusic();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
