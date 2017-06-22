package Primitives;

/**
 * Created by ephammer  on 21/03/2017.
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


    public int compareTo(Point3D point3D) {

        if (((Point2D)this).compareTo((Point2D)point3D) == 0)
            if (this.zCoordinate.compareTo(point3D.getzCoordinate()) == 0)
                return 0;
        return 1;
    }


    @Override
    public String toString() {
        return  "Primitives.Point3D{" +
                super.toString() +
                "zCoordinate=" + zCoordinate +
                '}';
    }

    public Point3D add(Point3D point3D)
    {
        this.setxCoordinate(this.getxCoordinate().add(point3D.getxCoordinate()));
        this.setyCoordinate(this.getyCoordinate().add(point3D.getyCoordinate()));
        zCoordinate.add(point3D.getzCoordinate());

        return this;
    }
    public void add(Vector vector) {

        this.getxCoordinate().add(vector.getOrigin().getxCoordinate());
        this.getyCoordinate().add(vector.getOrigin().getyCoordinate());
        this.getzCoordinate().add(vector.getOrigin().getzCoordinate());

    }

    public Point3D Substrct(Point3D point3D)
    {
        this.setxCoordinate(this.getxCoordinate().Substrct(point3D.getxCoordinate()));
        this.setyCoordinate(this.getyCoordinate().Substrct(point3D.getyCoordinate()));
        zCoordinate.Substrct(point3D.getzCoordinate());

        return this;
    }
    public void Substrct(Vector vector) {

        this.getxCoordinate().Substrct(vector.getOrigin().getxCoordinate());
        this.getyCoordinate().Substrct(vector.getOrigin().getyCoordinate());
        this.getzCoordinate().Substrct(vector.getOrigin().getzCoordinate());

    }


    public double distance(Point3D point3D)
    {
        return Math.sqrt(
                Math.pow(getxCoordinate().getPoint() - point3D.getxCoordinate().getPoint(), 2) +
                        Math.pow(getyCoordinate().getPoint() - point3D.getyCoordinate().getPoint(), 2) +
                        Math.pow(getzCoordinate().getPoint() - point3D.getzCoordinate().getPoint(), 2));
    }
}
