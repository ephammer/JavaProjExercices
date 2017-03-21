import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by kid0n on 21/03/2017.
 */
public class Vector {

    private Point3D origin;
    private Point3D point3D;

    public Vector(Point3D point3D) {
        origin = new Point3D();
        this.point3D = point3D;
    }

    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origin) {
        this.origin = origin;
    }

    public Vector(Coordinate xCoordinate, Coordinate yCoordinate, Coordinate zCoordinate) {
        origin = new Point3D();
        this.point3D = new Point3D(xCoordinate,yCoordinate,zCoordinate);
    }

    public Vector()
    {
        origin = new Point3D();
        point3D = new Point3D();
    }

    public Vector(Point3D origin, Point3D point3D) {
        this.origin = origin;
        this.point3D = point3D;
    }

    public Vector(Vector vector)
    {
        this.setPoint3D(vector.getPoint3D());
    }

    public Point3D getPoint3D() {
        return point3D;
    }

    public void setPoint3D(Point3D point3D) {
        this.origin = new Point3D();
        this.point3D = point3D;
    }

    public Vector add(Vector vector)
    {
       point3D.add(vector.getPoint3D());

       return this;
    }

    public Vector Substrct(Vector vector)
    {
        point3D.Substrct(vector.getPoint3D());

        return this;
    }

    public Vector scalarMult(double scalar)
    {
        point3D = new Point3D(point3D.getxCoordinate().getPoint()*scalar,
                point3D.getyCoordinate().getPoint()*scalar,
                point3D.getzCoordinate().getPoint()*scalar);

        return this;
    }

    public double length()
    {
        return origin.distance(point3D);
    }

    public Vector narmol()
    {
        return this.scalarMult(1/length());
    }

    public Vector crossProduct(Vector vector)
    {
        Vector newVector;

        Coordinate xCoordinate = new Coordinate(
                (this.getPoint3D().getyCoordinate().getPoint()*
                vector.getPoint3D().getzCoordinate().getPoint()) -
                (this.getPoint3D().getzCoordinate().getPoint()*
                        vector.getPoint3D().getyCoordinate().getPoint()));

        Coordinate yCoordinate = new Coordinate(
                (this.getPoint3D().getzCoordinate().getPoint()*
                vector.getPoint3D().getxCoordinate().getPoint()) -
                        (this.getPoint3D().getxCoordinate().getPoint()*
                                vector.getPoint3D().getzCoordinate().getPoint()));

        Coordinate zCoordinate = new Coordinate(
                (this.getPoint3D().getxCoordinate().getPoint()*
                vector.getPoint3D().getyCoordinate().getPoint()) -
                        (this.getPoint3D().getyCoordinate().getPoint()*
                                vector.getPoint3D().getxCoordinate().getPoint()));
        newVector = new Vector(xCoordinate,yCoordinate,zCoordinate);

        return newVector;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;

        Vector vector = (Vector) o;

        return getPoint3D() != null ? getPoint3D().equals(vector.getPoint3D()) : vector.getPoint3D() == null;
    }


}
