package GUI;

import Field.BattleField;
import XML.FileWriter;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Battle implements Runnable{
    private BattleField newBattle;
    private boolean inBattle;
    private FileWriter recordWriter;
    private CountDownLatch latch;
    private CalabashWorldController controller;

    public Battle(BattleField newBattle, boolean inBattle, FileWriter recordWriter, CalabashWorldController controller)
    {
        this.newBattle = newBattle;
        this.inBattle = inBattle;
        this.recordWriter = recordWriter;
        this.controller = controller;
    }

    public void battle()
    {
        int threadNum = newBattle.getAllcreatures().size();
        // 给子线程一个倒计时
        latch = new CountDownLatch(threadNum);
        newBattle.StartBattle(recordWriter, latch);
        try {
            // 等待所有子线程
            latch.await(20, TimeUnit.SECONDS); // 5秒超时
            System.out.println("Battle finished!");
            Platform.runLater(() -> {
                controller.BattleWin();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void run() {
        if(this.inBattle) {
            battle();
        }
    }

}
