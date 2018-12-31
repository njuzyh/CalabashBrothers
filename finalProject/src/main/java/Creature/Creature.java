package Creature;
import Annotation.Author;
import Field.*;
import javafx.application.Platform;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Author()
public class Creature implements Runnable{
    protected static int roundNum;
    protected String name;
    protected Position position;
    protected Image image;
    protected boolean justice;
    protected boolean alive;
    protected int hp;
    protected int attack;
    protected int defense;
    protected BattleField field;
    protected boolean winning;
    protected boolean fighting;
    protected ArrayList<Creature> enemy;
    protected Creature opponent;
    protected Creature nearestEnemy;
    protected CountDownLatch latch;
    protected int attacknum = 0;
    protected Image aliveimage;
    protected Image deadimage = new Image("/Image/dead.jpg");

    public Creature() {
        this.position = new Position();
        this.alive = true;
    }

    public Creature(BattleField field) {
        this.position = new Position();
        this.alive = true;
        this.field = field;
    }

    public Creature(int x, int y, BattleField field) {
        this.position = new Position(x, y);
        this.alive = true;
        this.field = field;
    }

    public void setRoundNum(int roundNum)
    {
        Creature.roundNum = roundNum;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public synchronized void hurt(int damage)
    {
        hp -= damage;
        this.die();
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    public  void setOpponent(Creature x)
    {
        this.opponent = x;
    }

    public Creature getOpponent()
    {
        return opponent;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public synchronized void die() {
        this.alive = false;
        field.clearUnit(this);
        this.image = deadimage;
        field.displayUnit(this);
    }

    public void revive()
    {
        this.alive = true;
        this.image = aliveimage;
    }

    public void addhp(int t)
    {
        hp += t;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public boolean isJustice()
    {
        return justice;
    }

    public boolean isFighting(){return  fighting;}

    public synchronized void move(Creature c1, Creature c2, Random random)
    {
        BattleMap battleMap = field.getbattleMap();
        int dx = c2.getX() - c1.getX();
        int dy = c2.getY() - c1.getY();
        int x1, y1;
        x1 = (dx == 0) ? 0 : dx / Math.abs(dx);
        y1 = (dy == 0) ? 0 : dy / Math.abs(dy);
        if (x1 != 0 && battleMap.isEmpty(c1.getX() + x1, c1.getY())) {
            field.clearUnit(c1);
            c1.setPosition(c1.getX() + x1, c1.getY());
            field.displayUnit(c1);
        } else if (y1 != 0 && battleMap.isEmpty(c1.getX(), c1.getY() + y1)) {
            field.clearUnit(c1);
            c1.setPosition(c1.getX(), c1.getY() + y1);
            field.displayUnit(c1);
        } else {
            if (c1.getX() > 0 && battleMap.isEmpty(c1.getX() - 1, c1.getY())) {
                field.clearUnit(c1);
                c1.setPosition(c1.getX() - 1, c1.getY());
                field.displayUnit(c1);
            }
            if (c1.getX() < 19 && battleMap.isEmpty(c1.getX() + 1, c1.getY())) {
                field.clearUnit(c1);
                c1.setPosition(c1.getX() + 1, c1.getY());
                field.displayUnit(c1);
            }
        }
        attacknum++;
        if (attacknum == 2) {
            remoteAttack();
            attacknum = 0;
        }
        field.updateCreatures();
        field.addRecord(roundNum);
        roundNum++;
    }
    public synchronized void remoteAttack()
    {
        if(this.isJustice()) {
            for (int i = 0; i < 3; i++)
                new Thread(new Bullet(this, field, i)).start();
        }
        else
            new Thread(new Bullet(this, field, 0)).start();
    }
    public synchronized void fight(Creature c1, Creature c2, Random random)
    {
        if (c1.isAlive() && c2.isAlive())
        {
            c1.fighting = true;
            c2.fighting = true;
            this.opponent = c2;
            c2.setOpponent(c1);
            int tmp = random.nextInt(2);
            if (tmp == 0) {
                field.clearUnit(c1);
                c1.die();
                System.out.println(c1.getName() + "近战死");
            } else {
                field.clearUnit(c2);
                c2.die();
                System.out.println(c2.getName() + "近战死");
            }
            field.updateCreatures();
            field.addRecord(roundNum);
            c1.fighting = false;
            c2.fighting = false;
            roundNum++;
        }
    }
    public void findEnemy()
    {
        ArrayList<Creature> newenemy = new ArrayList<Creature>();
        if(justice)
        {
            Monsters monsters = field.getAllmonsters();
            if(monsters.getSnake().isAlive())
                newenemy.add(monsters.getSnake());
            if(monsters.getScorpion().isAlive())
                newenemy.add(monsters.getScorpion());
            for (Sprite sprite:monsters.getSprites()) {
                if(sprite.isAlive())
                    newenemy.add(sprite);
            }
        }
        else
        {
            Heroes heroes = field.getAllheroes();
            if(heroes.getGrandfather().isAlive())
                newenemy.add(heroes.getGrandfather());
            for (CalabashBoy huluwa:heroes.getCalabashBrothers()) {
                if(huluwa.isAlive())
                    newenemy.add(huluwa);
            }
        }
       enemy = newenemy;
    }
    public boolean isEnemyAllDead()
    {
        for (Creature x:enemy) {
            if(x.isAlive())
                return false;
        }
        return true;
    }
    public int findNearestEnemy()
    {
        int mindistance = 100, distance = 0;
        for (Creature temp:enemy)
        {
            distance = Math.abs(temp.getX() - this.getX()) + Math.abs(temp.getY() - this.getY());
            if(distance < mindistance)
            {
                nearestEnemy = temp;
                mindistance = distance;
            }
        }
        return mindistance;
    }
    public ArrayList<Creature> getEnemy()
    {
        return enemy;
    }
    public Creature getNearestEnemy()
    {
        return nearestEnemy;
    }
    public void setLatch(CountDownLatch latch)
    {
        this.latch = latch;
    }
    public void run() {
        try {
            while (isAlive() && !field.isEnd()) {
                findEnemy();
                if (isEnemyAllDead()) {
                    field.setWinner(this);
                    break;
                }
                Random random = new Random();
                int mindistance = findNearestEnemy();
                if (mindistance == 1) {
                    synchronized (field) {
                        fight(this, nearestEnemy, random);
                    }
                } else {
                    synchronized (field) {
                        move(this, nearestEnemy, random);
                    }
                }
                try {
                    Thread.sleep(random.nextInt(500) + 300);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        } finally {
            latch.countDown();
        }
    }
}
