package Formation;
import Creature.Creature;

import java.util.ArrayList;

public class Yanxing extends Formation{
    public Yanxing()
    {
        num = 5;
        formationname = "雁行";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0) {
            for (int i = 0; i < allcreature.size(); i++) {
                allcreature.get(i).setPosition(13 - i, 9 - i);
            }
        }
        else
        {
            for (int i = 0; i < allcreature.size(); i++) {
                allcreature.get(i).setPosition(12 - i, 15 - i);
            }
        }
    }
}
