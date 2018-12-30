package Creature;

import Field.BattleField;
import javafx.scene.image.Image;

public class Scorpion extends Creature{
    public Scorpion(BattleField field) {
        super(field);
        justice = false;
        name = "蝎子精";
        image = new Image("/Image/scorpion.jpg");
    }
    public Scorpion(int x, int y, BattleField field) {
        super(x, y, field);
        justice = false;
        name = "蝎子精";
        image = new Image("/Image/scorpion.jpg");
    }
    public Scorpion()
    {
        super();
        justice = false;
        name = "蝎子精";
    }
}
