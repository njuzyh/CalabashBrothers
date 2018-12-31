package Field;

import Creature.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void getCreatureName() {
        Unit<Creature> x = new Unit<Creature>(4, 5);
        System.out.println(x.getCoordinateX() + " " + x.getCoordinateY());
        x.setCreature(new Grandpa());
        System.out.println(x.getCreatureName());
    }
}