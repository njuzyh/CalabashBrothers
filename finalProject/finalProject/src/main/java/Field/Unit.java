package Field;

import Creature.Creature;

public class Unit<T extends Creature> {
    private Position coordinate;
    private T CreatureHere;
    public Unit()
    {
        coordinate = new Position();
        CreatureHere = null;
    }
    public Unit(Position initCoordinate)
    {
        coordinate = initCoordinate;
        CreatureHere = null;
    }
    public Unit(int x, int y)
    {
        coordinate = new Position(x, y);
    }
    public boolean isEmpty()
    {
        if(CreatureHere == null)
            return true;
        else
            return false;
    }
    public Creature getCreature()
    {
        return CreatureHere;
    }
    public String getCreatureName()
    {
        return CreatureHere.getName();
    }
    public void setCreature(T creatureHere) {
        CreatureHere = creatureHere;
    }
    public int getCoordinateX()
    {
        return coordinate.getX();
    }
    public int getCoordinateY()
    {
        return coordinate.getY();
    }
    public void setCoordinate(Position Coordinate)
    {
        coordinate = Coordinate;
    }
    public void cleanUnit()
    {
        CreatureHere = null;
    }
}
