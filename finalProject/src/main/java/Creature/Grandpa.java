package Creature;

import Field.BattleField;
import javafx.scene.image.Image;

public class Grandpa extends Creature{
    public Grandpa(BattleField field)
    {
        super(field);
        justice = true;
        name = "爷爷";
        this.aliveimage = new Image("/Image/grandpa.jpg");
        this.image = this.aliveimage;
    }
    public Grandpa(int x, int y, BattleField field)
    {
        super(x, y, field);
        justice = true;
        name = "爷爷";
        this.aliveimage = new Image("/Image/grandpa.jpg");
        this.image = this.aliveimage;
    }
    public Grandpa()
    {
        super();
        justice = true;
        name = "爷爷";
    }
}
