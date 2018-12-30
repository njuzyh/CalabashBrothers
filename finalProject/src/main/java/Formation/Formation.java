package Formation;
import Creature.*;

import java.util.ArrayList;

public abstract class Formation {
    protected int num;
    protected String formationname;
    public Formation()
    {
        this.num = 0;
    }
    public abstract void showFormation(ArrayList<? extends Creature> allcreature, int direction);
    public String getFormationname()
    {
        return formationname;
    }
    public int getCreatureNum()
    {
        return num;
    }
}
