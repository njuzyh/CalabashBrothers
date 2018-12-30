package Field;
import Creature.*;
import Formation.*;
import GUI.CalabashWorldController;
import XML.FileReader;
import XML.FileWriter;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BattleField {
    private BattleMap<Creature> battleMap;
    private Heroes allheroes;
    private Monsters allmonsters;
    private GraphicsContext gc;
    private GraphicsContext bulletgc;
    private ArrayList<Creature> allcreatures;
    private Creature winner;
    private boolean end = false;
    private FileWriter recordWriter;
    public BattleField(GraphicsContext gc, GraphicsContext bulletgc){
        this.gc = gc;
        this.bulletgc = bulletgc;
        battleMap = new BattleMap<Creature>(20, 20);
        allcreatures = new ArrayList<Creature>();
        allmonsters = new Monsters(this);
        allheroes = new Heroes(this);
        allheroes.setFormation(new Changshe());
        allmonsters.setFormation(new Changshe());
        updateCreatures();
        for (Creature x:allcreatures) {
            x.setRoundNum(1);
        }
    }
    public BattleField()
    {
        battleMap = new BattleMap<Creature>(20, 20);
        allcreatures = new ArrayList<Creature>();
        allmonsters = new Monsters(this);
        allheroes = new Heroes(this);
        allheroes.setFormation(new Changshe());
        allmonsters.setFormation(new Changshe());
        updateCreatures();
    }
    public void StartBattle(FileWriter recordWriter, CountDownLatch latch)
    {
        startRecord(recordWriter);
        System.out.println("开始多线程");
        setAllThreads(latch);
    }
    public void setAllThreads(CountDownLatch latch)
    {
        Executor executor = Executors.newFixedThreadPool(allcreatures.size());
        for (Creature x : allcreatures) {
            x.setLatch(latch);
            executor.execute(x);
        }
    }
    public void clearUnit(Creature temp)
    {
        battleMap.cleanOneUnit(temp.getX(), temp.getY());
        final int Y = temp.getY();
        final int X = temp.getX();
        if(temp instanceof Bullet)
            Platform.runLater(() -> bulletgc.clearRect(Y * 30, X * 30, 30, 30));
        else
            Platform.runLater(() -> gc.clearRect(Y * 30, X * 30, 30, 30));
    }
    public void cleanBattle() {
        Platform.runLater(() -> bulletgc.clearRect(0, 0, 600, 630));
        Platform.runLater(() -> gc.clearRect(0, 0, 600, 630));
        battleMap.cleanMap();
    }
    public void updateBattle(Formation formation, int direction)
    {
        battleMap.cleanMap();
        if(direction == 1)
            allheroes.setFormation(formation);
        else
            allmonsters.setFormation(formation);
        updateCreatures();
    }
    public void displayBattle()
    {
        allheroes.show(battleMap);
        allmonsters.show(battleMap);
        battleMap.showMap();
    }
    public void displayGUIBattle()
    {
        allheroes.show(battleMap);
        allmonsters.show(battleMap);
        battleMap.showGUIMap(gc, bulletgc);
    }
    public void displayUnit(Creature temp)
    {
        battleMap.setBattleCreature(temp.getX(), temp.getY(), temp);
        final Image image = temp.getImage();
        final int X = temp.getX();
        final int Y = temp.getY();
        if(temp instanceof Bullet)
            Platform.runLater(() -> bulletgc.drawImage(image, Y * 30, X * 30, 30, 30));
        else
            Platform.runLater(() -> gc.drawImage(image, Y * 30, X * 30, 30, 30));
    }
    public void updateCreatures()
    {
        ArrayList<Creature> temp = new ArrayList<Creature>();
        temp.add(allheroes.getGrandfather());
        temp.addAll(allheroes.getCalabashBrothers());
        temp.add(allmonsters.getScorpion());
        temp.add(allmonsters.getSnake());
        temp.addAll(allmonsters.getSprites());
        allcreatures = temp;
    }
    public void setWinner(Creature x)
    {
        winner = x;
        end = true;
    }
    public boolean isEnd()
    {
        return end;
    }
    public Creature getWinner(){ return winner; }
    public ArrayList<Creature> getAllcreatures()
    {
        return allcreatures;
    }
    public Heroes getAllheroes()
    {
        return allheroes;
    }
    public Monsters getAllmonsters()
    {
        return allmonsters;
    }
    public BattleMap getbattleMap()
    {
        return battleMap;
    }
    public GraphicsContext getGc()
    {
        return gc;
    }
    public void startRecord(FileWriter recordWriter)
    {
        this.recordWriter = recordWriter;
        recordWriter.initalRecord(this);
    }
    public void addRecord(int n)
    {
        recordWriter.addRecord(this, n);
    }
    public void findWinner()
    {
        for (Creature x:allcreatures) {
            if(x.isAlive()) {
                winner = x;
                break;
            }
        }
    }
    public void startReplay(FileReader recordReader){
        cleanBattle();
        recordReader.initCreature(this);
        displayGUIBattle();
    }
    public void showRound(FileReader recordReader, int roundNum)
    {
        cleanBattle();
        for (int j = 0; j < allcreatures.size(); j++) {
            recordReader.setCharacter(allcreatures.get(j), j + 1, roundNum, this);
        }
        displayGUIBattle();
    }
    /*private int ScorpionAbscissa;
    private int ScorpionOrdinate;
    private int SnakeAbscissa;
    private int SnakeOrdinate;
    private int GrandpaAbscissa;
    private int GrandpaOrdinate;
    private int SpriteNum;
    private char Map[][];
    public BattleField(CalabashBrothers Brothers, Snake SnakeKing, Scorpion ScorpionKing, Grandpa oldGrandpa, Formation formation) {
        Map = new char[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Map[i][j] = ' ';
            }
        }
        updateBattle(Brothers, SnakeKing, ScorpionKing, oldGrandpa, formation);
    }
    public void clearBattle(Formation formation)
    {
        int SpriteAbscissa, SpriteOrdinate;
        Map[SnakeAbscissa][SnakeOrdinate] = ' ';
        Map[ScorpionAbscissa][ScorpionOrdinate] = ' ';
        Map[GrandpaAbscissa][GrandpaOrdinate] = ' ';
        SpriteNum = formation.getCreatureNum();
        for(int i = 0; i < SpriteNum; i++)
        {
            SpriteAbscissa = formation.getCreatureX(i);
            SpriteOrdinate = formation.getCreatureY(i);
            Map[SpriteAbscissa][SpriteOrdinate] = ' ';
        }
        for(int i = 0; i < 7; i++)
        {
            Map[7 + i][5] = ' ';
        }
    }
    public void updateBattle(CalabashBrothers Brothers, Snake SnakeKing, Scorpion ScorpionKing, Grandpa oldGrandpa, Formation formation)
    {
        int SpriteAbscissa, SpriteOrdinate;
        //formation.showFormation();
        ScorpionAbscissa = ScorpionKing.getX();
        ScorpionOrdinate = ScorpionKing.getY();
        SnakeAbscissa = SnakeKing.getX();
        SnakeOrdinate = SnakeKing.getY();
        GrandpaAbscissa = oldGrandpa.getX();
        GrandpaOrdinate = oldGrandpa.getY();
        SpriteNum = formation.getCreatureNum();
        for(int i = 0; i < SpriteNum; i++)
        {
            SpriteAbscissa = formation.getCreatureX(i);
            SpriteOrdinate = formation.getCreatureY(i);
            Map[SpriteAbscissa][SpriteOrdinate] = 'L';
        }
        Map[SnakeAbscissa][SnakeOrdinate] = 'S';
        Map[ScorpionAbscissa][ScorpionOrdinate] = 'X';
        Map[GrandpaAbscissa][GrandpaOrdinate] = 'G';
        displayCalabashBrothers(Brothers);
    }
    public void displayCalabashBrothers(CalabashBrothers Brothers)
    {
        for(int i = 0; i < 7; i++)
        {
            Map[7 + i][5] = Brothers.getCalabashBoySymbol(i);
        }
    }
    public void displayBattle()
    {
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                System.out.print(Map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public void displayGUIBattle(GraphicsContext gc)
    {
        Image image;
        for(int i = 0; i < 20; i++)
        {
            for(int j = 0; j < 20; j++)
            {
                switch (Map[i][j])
                {
                    case 'S':
                        image = new Image("Resources/"+"snake.jpg");;
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case 'X':
                        image = new Image("Resources/"+"scorpion.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case 'G':
                        image = new Image("Resources/"+"grandpa.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case 'L':
                        image = new Image("Resources/"+"louluo.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '大':
                        image = new Image("Resources/"+"brother1.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '二':
                        image = new Image("Resources/"+"brother2.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '三':
                        image = new Image("Resources/"+"brother3.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '四':
                        image = new Image("Resources/"+"brother4.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '五':
                        image = new Image("Resources/"+"brother5.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '六':
                        image = new Image("Resources/"+"brother6.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                    case '七':
                        image = new Image("Resources/"+"brother7.jpg");
                        gc.drawImage(image, j*30, i*30, 30, 30);
                        break;
                }
            }
        }
    }
    public static void main(String []args)
    {
        int []array = {7, 6, 5, 1, 2, 4, 3};
        Scorpion ScorpionKing = new Scorpion(10, 10);
        Snake SnakeKing = new Snake(10, 19);
        Grandpa oldGrandpa = new Grandpa(10, 0);
        CalabashBrothers SevenBrothers = new CalabashBrothers(array);
        Changshe cs = new Changshe();
        Chonge ce = new Chonge();
        Fangyuan fy = new Fangyuan();
        Fengshi fs = new Fengshi();
        Heyi hy = new Heyi();
        Yanxing yx = new Yanxing();
        Yanyue yy = new Yanyue();
        Yulin yl = new Yulin();
        BattleField newBattle = new BattleField(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, cs);
        newBattle.displayBattle();
        newBattle.clearBattle(cs);
        SevenBrothers.BubbleSort();
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, ce);
        newBattle.displayBattle();
        newBattle.clearBattle(ce);
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, fy);
        newBattle.displayBattle();
        newBattle.clearBattle(fy);
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, fs);
        newBattle.displayBattle();
        newBattle.clearBattle(fs);
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, hy);
        newBattle.displayBattle();
        newBattle.clearBattle(hy);
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, yx);
        newBattle.displayBattle();
        newBattle.clearBattle(yx);
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, yy);
        newBattle.displayBattle();
        newBattle.clearBattle(yy);
        newBattle.updateBattle(SevenBrothers, SnakeKing, ScorpionKing, oldGrandpa, yl);
        newBattle.displayBattle();
        newBattle.clearBattle(yl);
    }*/
}
