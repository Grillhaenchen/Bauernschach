package Infrastructure;

public abstract class Figure {
    protected FigureColor Color;
    protected Position position;

    public Figure(int X, int Y) {
        position = new Position(X, Y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
