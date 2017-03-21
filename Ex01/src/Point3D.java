/**
 * Created by kid0n on 21/03/2017.
 */
public class Point3D extends Point2D {

    private Coordinate zCoordinate;

    public Point3D(Coordinate xCoordinate, Coordinate yCoordinate, Coordinate zCoordinate) {
        super(xCoordinate, yCoordinate);
        this.zCoordinate = zCoordinate;
    }

    public Point3D() {
        super();
        this.zCoordinate = new Coordinate(0);
    }

    public Point3D(double xPoint, double yPoint, double zPoint) {
        super(xPoint, yPoint);
        this.zCoordinate = new Coordinate(zPoint);
    }

    public Point3D(Point3D point3D)
    {
        super(point3D.getxCoordinate(),point3D.getyCoordinate());
        this.zCoordinate = point3D.zCoordinate;
    }

    public Coordinate getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(Coordinate zCoordinate) {
        this.zCoordinate = zCoordinate;
    }
}
