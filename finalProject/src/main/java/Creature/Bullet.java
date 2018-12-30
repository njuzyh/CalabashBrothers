package Creature;

import Field.BattleField;
import Field.BattleMap;
import Field.Position;
import javafx.scene.image.Image;

import java.util.Random;

public class Bullet extends Creature{
    private Creature master;
    private int damage;
    private int speed;
    private boolean isRecived;
    private boolean invalid;
    private int direction;
    private BattleField field;

    public Bullet(Creature master, BattleField field, int direction) {
        this.position = master.getPosition();
        this.direction = direction;
        this.master = master;
        this.isRecived = false;
        this.invalid = false;
        this.justice = master.isJustice();
        if(justice)
        {
            if(master.getName().equals("老四"))
                this.image = new Image("/Image/fire.gif");
            else if(master.getName().equals("老五"))
                this.image = new Image("/Image/water.gif");
            else
                this.image = new Image("/Image/calabash.png");
        }
        else
            this.image = new Image("/Image/Bullet.png");
        this.field = field;
    }

    public Creature getMaster() {
        return master;
    }

    public boolean isRecived() {
        return isRecived;
    }

    public synchronized void move(BattleMap newMap) {
        int x = position.getX();
        int y = position.getY();
        switch (direction)
        {
            case 0:
                y += justice ? 1 : -1;
                break;
            case 1:
                x += 1;
                y += justice ? 1 : -1;
                break;
            case 2:
                x -= 1;
                y += justice ? 1 : -1;
        }
        if(x <= 19 && x >= 0 &&  y <= 19 && y >= 0 && !touchTarget(newMap))
        {
            field.clearUnit(this);
            position = new Position(x, y);
            field.displayUnit(this);
        }
        else
        {
            invalid = true;
            field.clearUnit(this);
        }
    }

    public synchronized boolean touchTarget(BattleMap newMap) {
        int x = position.getX();
        int y = position.getY();
        if (!newMap.isEmpty(x, y)) {
            Creature cartoonCharacter = newMap.getOneCreature(x, y);
            if(cartoonCharacter instanceof Bullet)
            {
               return false;
            }
            else {
                if(cartoonCharacter.isAlive()) {
                    if (cartoonCharacter.isJustice() != justice) {
                        cartoonCharacter.hurt(damage);
                        isRecived = true;
                        System.out.println(cartoonCharacter.getName() + "被射死");
                        field.clearUnit(this);
                        return true;
                    } else {
                        return false;
                    }
                }
                else
                    return false;
            }
        }
        else
            return false;
    }

    public void run() {
        field.displayUnit(this);
        while(!invalid && !isRecived)
        {
            synchronized (field) {
                move(field.getbattleMap());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
