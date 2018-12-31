package Formation;
import Creature.*;

import java.util.ArrayList;

public class Fengshi extends Formation{
    public Fengshi()
    {
        num = 12;
        formationname = "锋矢";
    }
    @Override
    public void showFormation(ArrayList<? extends Creature> allcreature, int direction) {
        if(direction == 0) {
            for (int i = 0; i < 3; i++) {
                allcreature.get(i).setPosition(10, 6 + i);
            }
            for (int i = 3; i < 5; i++) {
                allcreature.get(i).setPosition(9 - (i - 3), 7 - (i - 3));
            }
            for (int i = 5; i < allcreature.size(); i++) {
                allcreature.get(i).setPosition(11 + (i - 5), 7 - (i - 5));
            }
        }
        else
        {
            for (int i = 0; i < 6; i++) {
                allcreature.get(i).setPosition(10, 11 + i);
            }
            for (int i = 6; i < 9; i++) {
                allcreature.get(i).setPosition(11 + i - 6, 11 + i - 6);
            }
            for (int i = 9; i < 12; i++) {
                allcreature.get(i).setPosition(9 - (i - 9), 11 + i - 9);
            }
        }
    }
}
