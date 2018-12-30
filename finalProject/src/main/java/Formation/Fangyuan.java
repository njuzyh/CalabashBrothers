package Formation;

import Creature.Creature;

import java.util.ArrayList;

public class Fangyuan extends Formation{
    public Fangyuan()
    {
        num = 8;
        formationname = "方圆";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0)
        {
            for(int i = 0; i < 3; i++)
            {
                allcreature.get(i).setPosition(10 - i, 8 - i);
            }
            for(int i = 3; i < 5; i++)
            {
                allcreature.get(i).setPosition(8 + i, 10 - i);
            }
            for(int i = 5; i < allcreature.size(); i++)
            {
                allcreature.get(i).setPosition(9 + 2 * (i - 5), 5);
            }
        }
        else
        {
            System.out.print(allcreature.size());
            for(int i = 0; i < 3; i++)
            {
                allcreature.get(i).setPosition(10 + i, 11 + i);
            }
            for(int i = 3; i < 5; i++)
            {
                allcreature.get(i).setPosition(9 - (i - 3), 12 + i - 3);
            }
            allcreature.get(5).setPosition(11, 14);
            allcreature.get(6).setPosition(10, 15);
            allcreature.get(7).setPosition(9, 14);
        }
    }
}
