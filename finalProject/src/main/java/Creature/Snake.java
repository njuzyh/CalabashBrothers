package Creature;

import Field.BattleField;
import javafx.scene.image.Image;

public class Snake extends Creature{
    public Snake(BattleField field)
    {
        super(field);
        justice = false;
        name = "蛇精";
        image = new Image("/Image/snake.jpg");
    }
    public Snake(int x, int y, BattleField field)
    {
        super(x, y, field);
        justice = false;
        name = "蛇精";
        image = new Image("/Image/snake.jpg");
    }
    public Snake()
    {
        super();
        justice = false;
        name = "蛇精";
    }
}
