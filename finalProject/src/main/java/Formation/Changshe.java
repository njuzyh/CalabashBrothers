package Formation;
import Creature.*;

import java.util.ArrayList;

public class Changshe extends Formation{
    public Changshe()
    {
        num = 6;
        formationname = "长蛇";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0)
        {
            for(int i = 0; i < allcreature.size(); i++)
            {
                allcreature.get(i).setPosition(7 + i, 7);
            }
        }
        else
        {
            for(int i = 0; i < num; i++)
            {
                allcreature.get(i).setPosition(7 + i, 12);
            }
        }
    }
}
