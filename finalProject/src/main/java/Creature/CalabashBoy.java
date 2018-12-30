package Creature;

import Field.BattleField;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class CalabashBoy extends Creature{
    private Color color;
    private int order;
    CalabashBoy(Color color, BattleField field)
    {
        super(field);
        justice = true;
        this.name=color.getName();
        this.color=color;
        this.order=color.ordinal() + 1;
        this.image = new Image("/Image/brother" + order + ".jpg");
    }
    CalabashBoy(Color color)
    {
        super();
        justice = true;
        this.name=color.getName();
        this.color=color;
        this.order=color.ordinal() + 1;
        //this.image = new Image("Resources/"+ "brother" + order + ".jpg");
    }
    public int getOrder()
    {
        return order;
    }
    public int CompareOrder(CalabashBoy Boy)
    {
        if(order < Boy.order)
            return -1;
        else if(order == Boy.order)
            return 0;
        else
            return 1;
    }
    public int CompareColor(CalabashBoy Boy)
    {
        if(color.ordinal() < Boy.color.ordinal())
            return -1;
        else if(color.ordinal() == Boy.color.ordinal())
            return 0;
        else
            return 1;
    }
}
