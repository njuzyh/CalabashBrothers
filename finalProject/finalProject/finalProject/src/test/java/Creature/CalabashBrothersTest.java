package Creature;

import Field.BattleField;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalabashBrothersTest {

    @Test
    public void calabashBoySort() {
        int []array = {7, 6, 5, 4, 3, 2, 1};
        CalabashBrothers brothers = new CalabashBrothers(array);
        brothers.CountOff();
        brothers.CalabashBoySort();
        brothers.CountOff();
    }
}