package Field;

import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void equals() {
        Position x = new Position(5, 4);
        Position y = new Position(4, 5);
        Position z = new Position(5, 4);
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
    }
}