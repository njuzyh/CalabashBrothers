package Field;

import Creature.Grandpa;
import Creature.Scorpion;
import Creature.Snake;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleMapTest {

    @Test
    public void showMap() {
        BattleMap temp = new BattleMap(10, 10);
        temp.setBattleCreature(0, 0, new Grandpa());
        temp.setBattleCreature(5, 5, new Snake());
        temp.setBattleCreature(9, 9, new Scorpion());
        temp.showMap();
    }
}