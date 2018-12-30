package Field;

public class Position {
    private int x;
    private int y;
    public Position()
    {
        this.x = 0;
        this.y = 0;
    }
    public Position(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return  x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setPosition(int x, int y)
    {
        setX(x);
        setY(y);
    }
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Position newobject = (Position) object;
        if (this.x == newobject.getX() && this.y == newobject.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
