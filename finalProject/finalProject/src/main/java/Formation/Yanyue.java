package Formation;

import Creature.Creature;

import java.util.ArrayList;

public class Yanyue extends Formation{
    public Yanyue()
    {
        num = 19;
        formationname = "偃月";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0) {
            for(int i = 0; i < 3; i++)
            {
                allcreature.get(i).setPosition(10, 6 + i);
            }
            for(int i = 3; i < 5; i++)
            {
                allcreature.get(i).setPosition(9 - (i - 3), 6 - (i - 3));
            }
            for(int i = 5; i < allcreature.size(); i++)
            {
                allcreature.get(i).setPosition(11 + (i - 5), 6 - (i - 5));
            }
        }
        else
        {
            for(int i = 0; i < 3; i++)
            {
                allcreature.get(i).setPosition(10, 11 + i);
            }
            for(int i = 3; i < 6; i++)
            {
                allcreature.get(i).setPosition(9, 11 + i - 3);
            }
            for(int i = 6; i < 9; i++)
            {
                allcreature.get(i).setPosition(11, 11 + i - 6);
            }
            for(int i = 9; i < 11; i++)
            {
                allcreature.get(i).setPosition(8 - (i - 9), 13 + (i - 9));
            }
            for(int i = 11; i < 13; i++)
            {
                allcreature.get(i).setPosition(12 + (i - 11), 13 + (i - 11));
            }
            for(int i = 13; i < 16; i++)
            {
                allcreature.get(i).setPosition(8 - (i - 13), 14 + (i - 13));
            }
            for(int i = 16; i < 19; i++)
            {
                allcreature.get(i).setPosition(12 + (i - 16), 14 + (i - 16));
            }
        }
    }
}
