/**
 * Created by Emmanuel Elnekave on 20/03/2017.
 */
public class Point2D {

    private Coordinate xCoordinate;
    private Coordinate yCoordinate;

    public Point2D(){
        xCoordinate = new Coordinate(0);
        yCoordinate = new Coordinate(0);
    }

    public Point2D(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Point2D(double xPoint, double yPoint)
    {
        this.xCoordinate = new Coordinate(xPoint);
        this.yCoordinate = new Coordinate(yPoint);
    }

    public Point2D(Point2D point2D)
    {
        this.xCoordinate = point2D.getxCoordinate();
        this.yCoordinate = point2D.getyCoordinate();
    }

    public Coordinate getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Coordinate xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Coordinate getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Coordinate yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
