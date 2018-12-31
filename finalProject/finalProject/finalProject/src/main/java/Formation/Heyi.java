package Formation;

import Creature.Creature;

import java.util.ArrayList;

public class Heyi extends Formation{
    public Heyi()
    {
        num = 7;
        formationname = "鹤翼";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0) {
            for (int i = 0; i < 4; i++) {
                allcreature.get(i).setPosition(10 - i, 8 - i);
            }
            for (int i = 4; i < allcreature.size(); i++) {
                allcreature.get(i).setPosition(11 + i - 4, 7 - (i - 4));
            }
        }
        else
        {
            for (int i = 0; i < 3; i++) {
                allcreature.get(i).setPosition(9 - i, 12 + i);
            }
            for (int i = 3; i < 6; i++) {
                allcreature.get(i).setPosition(11 + i - 3, 12 + i - 3);
            }
            allcreature.get(6).setPosition(10, 11);
        }
    }
}
