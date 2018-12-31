package Formation;

import Creature.*;

import java.util.ArrayList;

public class Chonge extends Formation {
    public Chonge()
    {
        num = 6;
        formationname = "冲轭";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0)
        {
            for(int i = 0; i < 3; i++)
            {
                allcreature.get(i).setPosition(8 + 2 * i, 7);
            }
            for(int i = 3; i < allcreature.size(); i++)
            {
                allcreature.get(i).setPosition(7 + 2 * (i - 3), 6);
            }
        }
        else
        {
            for(int i = 0; i < 3; i++)
            {
                allcreature.get(i).setPosition(8 + 2 * i, 12);
            }
            for(int i = 3; i < num; i++)
            {
                allcreature.get(i).setPosition(7 + 2 * (i - 3), 13);
            }
        }
    }
}
