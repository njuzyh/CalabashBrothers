package Creature;

import Field.BattleField;
import javafx.scene.image.Image;

public class Sprite extends Creature{
    private int order;
    public Sprite(BattleField field, int num)
    {
        super(field);
        justice = false;
        order = num;
        name = "喽啰" + order;
        this.aliveimage = new Image("/Image/louluo.jpg");
        this.image = this.aliveimage;
    }
    public Sprite(int x, int y, BattleField field, int num) {
        super(x, y, field);
        justice = false;
        order = num;
        name = "喽啰" + order;
        this.aliveimage = new Image("/Image/louluo.jpg");
        this.image = this.aliveimage;
    }
}
