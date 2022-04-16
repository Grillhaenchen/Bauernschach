package Infrastructure;

public class Position {
    public Position(int _x,int _y){
        X=_x;
        Y=_y;
    }

    private int X;
    private int Y;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
