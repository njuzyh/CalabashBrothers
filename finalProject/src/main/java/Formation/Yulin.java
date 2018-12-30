package Formation;

import Creature.Creature;

import java.util.ArrayList;

public class Yulin extends Formation{
    public Yulin()
    {
        num = 16;
        formationname = "鱼鳞";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0) {
            for (int i = 0; i < 4; i++) {
                allcreature.get(i).setPosition(8 + i, 6);
            }
            for (int i = 4; i < 6; i++) {
                allcreature.get(i).setPosition(9 + (i - 4), 7);
            }
            allcreature.get(6).setPosition(10, 8);
        }
        else
        {
            for (int i = 0; i < 4; i++) {
                allcreature.get(i).setPosition(10 - i, 11 + i);
            }
            for (int i = 4; i < 6; i++) {
                allcreature.get(i).setPosition(12 + (i - 4), 13 + (i - 4));
            }
            for (int i = 6; i < 11; i++) {
                allcreature.get(i).setPosition(8 + (i - 6), 14);
            }
            for (int i = 11; i < 14; i++) {
                allcreature.get(i).setPosition(9 + (i - 11), 13);
            }
            allcreature.get(14).setPosition(10, 12);
            allcreature.get(15).setPosition(10, 15);
        }
    }
}
