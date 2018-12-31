package Field;

import Creature.*;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BattleMap<T extends Creature> {
    private Unit<T> battlemap[][];
    private int sizeM;
    private int sizeN;
    public BattleMap(int M, int N)
    {
        sizeM = M;
        sizeN = N;
        battlemap = new Unit[M][N];
        for(int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                battlemap[i][j] = new Unit<T>(i, j);
            }
        }
    }
    public int getSizeM()
    {
        return sizeM;
    }
    public int getSizeN()
    {
        return sizeN;
    }
    public boolean isEmpty(int x, int y)
    {
        return battlemap[x][y].isEmpty();
    }
    public void setBattleCreature(int x, int y, T creature)
    {
        battlemap[x][y].setCreature(creature);
    }
    public void cleanOneUnit(int x, int y)
    {
        battlemap[x][y].cleanUnit();
    }
    public void cleanMap()
    {
        for(int i = 0; i < sizeM; i++)
        {
            for(int j = 0; j < sizeN; j++)
            {
                cleanOneUnit(i, j);
            }
        }
    }
    public void showMap()
    {
        for (int i = 0; i < sizeM; i++){
            for (int j = 0; j < sizeN; j++){
                if (battlemap[i][j].isEmpty()){
                    System.out.print(" \t \t");
                } else {
                    Creature temp = battlemap[i][j].getCreature();
                    if(temp.isAlive())
                        System.out.print(battlemap[i][j].getCreatureName()+"\t");
                    else
                        System.out.print("dead"+"\t");
                }
            }
            System.out.println();
        }
    }
    public void showGUIMap(GraphicsContext gc, GraphicsContext bulletgc)
    {
        for(int i = 0; i < sizeM; i++)
        {
            for(int j = 0; j < sizeN; j++)
            {
                if(!battlemap[i][j].isEmpty()) {
                    Creature temp = getOneCreature(i, j);
                    Image image = temp.getImage();
                    final int Y = i * 30;
                    final int X = j * 30;
                    if(temp instanceof Bullet)
                        Platform.runLater(() -> bulletgc.drawImage(image, X, Y, 30, 30));
                    else
                        Platform.runLater(() -> gc.drawImage(image, X, Y, 30, 30));
                }
            }
        }
    }
    public Creature getOneCreature(int x, int y)
    {
        return battlemap[x][y].getCreature();
    }
}
