package Infrastructure;

public abstract class Figure {
    public Figure(int X,int Y){
        position=new Position(X,Y);
    }

    protected FigureColor Color;

    protected Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
