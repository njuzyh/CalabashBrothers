package Creature;

import Field.BattleField;
import Field.BattleMap;
import Formation.Formation;

import java.util.ArrayList;

public class Monsters implements Queueup{
    private Snake snake ;
    private Scorpion scorpion ;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
    private int num ;
    private BattleField field;
    public Monsters(BattleField field) {
        snake = new Snake(8, 19, field);
        scorpion = new Scorpion(12, 19, field);
        this.field = field;
        for(int i = 0; i < 6; i++)
        {
            sprites.add(new Sprite(field, i + 1));
        }
    }
    public Snake getSnake() {
        return snake;
    }
    public Scorpion getScorpion() {
        return scorpion;
    }
    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
    public void setFormation(Formation formation)
    {
        int creatureNum = formation.getCreatureNum();
        if(sprites.size() < creatureNum)
        {
            for(int i = sprites.size(); i < creatureNum; i++)
            {
                sprites.add(new Sprite(field, i + 1));
            }
        }
        else if(sprites.size() > creatureNum)
        {
            for(int i = sprites.size(); i > creatureNum; i--)
            {
                sprites.remove(i - 1);
            }
        }
        formation.showFormation(sprites, 1);
    }
    public void show(BattleMap space)
    {
        if(snake.isAlive())
            space.setBattleCreature(snake.getX(), snake.getY(), snake);
        if(scorpion.isAlive())
            space.setBattleCreature(scorpion.getX(), scorpion.getY(), scorpion);
        for(int i = 0; i < sprites.size(); i++)
        {
            Sprite temp = sprites.get(i);
            if(temp.isAlive())
                space.setBattleCreature(temp.getX(), temp.getY(), temp);
        }
    }
    public boolean isAllDead()
    {
        for(Sprite x:sprites)
        {
            if(x.isAlive())
                return false;
        }
        return !scorpion.isAlive() && !snake.isAlive();
    }
}
