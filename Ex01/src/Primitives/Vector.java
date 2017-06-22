package Primitives;

/**
 * Created by ehammer on 21/03/2017.
 */
public class Vector implements Comparable<Vector>{

    private Point3D origin;

    public Vector(Point3D point3D) {
        origin = new Point3D(point3D);
    }


    public Vector()
    {
        origin = new Point3D();
    }

    public Vector(Point3D origin, Point3D point3D) {
        this(point3D.getxCoordinate().getPoint() - origin.getxCoordinate().getPoint(),
                point3D.getyCoordinate().getPoint() - origin.getyCoordinate().getPoint(),
                point3D.getzCoordinate().getPoint() - origin.getzCoordinate().getPoint());
    }

    public Vector(Vector vector)
    {
        this.setOrigin(vector.getOrigin());
    }

    public Point3D getOrigin() {
        return origin;
    }

    public void setOrigin(Point3D origin) {
        this.origin = origin;
    }


    public Vector(double xOrigin,  double yOrigin, double zOrigin){
        origin =  new Point3D(new Coordinate(xOrigin),
                new Coordinate(yOrigin),
                new Coordinate(zOrigin));
    }

    public Vector add(Vector vector)
    {
       origin.add(vector.getOrigin());

       return this;
    }

    public Vector Substrct(Vector vector)
    {
        origin.Substrct(vector);

        return this;
    }

    public void scalarMult(double scalar)
    {
        this.origin.setxCoordinate(new Coordinate(
                scalar * origin.getxCoordinate().getPoint()));

        this.origin.setyCoordinate(new Coordinate(
                scalar * origin.getyCoordinate().getPoint()));

        this.origin.setzCoordinate(new Coordinate(
                scalar * origin.getzCoordinate().getPoint()));

    }

    public double length()
    {
        double x = this.getOrigin().getxCoordinate().getPoint();
        double y = this.getOrigin().getyCoordinate().getPoint();
        double z = this.getOrigin().getzCoordinate().getPoint();

        return Math.sqrt(Math.pow(x, 2) +
                Math.pow(y, 2) +
                Math.pow(z, 2));

    }

    public void narmol()
    {
        double x = this.getOrigin().getxCoordinate().getPoint();
        double y = this.getOrigin().getyCoordinate().getPoint();
        double z = this.getOrigin().getzCoordinate().getPoint();

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException();

        this.setOrigin(new Point3D(x/length,
                y/length,
                z/length));
    }

    public Vector crossProduct(Vector vector)
    {
        double x1 = this.getOrigin().getxCoordinate().getPoint();
        double y1 = this.getOrigin().getyCoordinate().getPoint();
        double z1 = this.getOrigin().getzCoordinate().getPoint();

        double x2 = vector.getOrigin().getxCoordinate().getPoint();
        double y2 = vector.getOrigin().getyCoordinate().getPoint();
        double z2 = vector.getOrigin().getzCoordinate().getPoint();

        return new Vector(y1 * z2 - z1 * y2,
                z1 * x2 - x1 * z2,
                x1 * y2 - y1 * x2);
    }

    public double dotProduct(Vector vector) {

        double x1 = this.getOrigin().getxCoordinate().getPoint();
        double y1 = this.getOrigin().getyCoordinate().getPoint();
        double z1 = this.getOrigin().getzCoordinate().getPoint();

        double x2 = vector.getOrigin().getxCoordinate().getPoint();
        double y2 = vector.getOrigin().getyCoordinate().getPoint();
        double z2 = vector.getOrigin().getzCoordinate().getPoint();

        return x1 * x2 + y1 * y2 + z1 * z2;

    }

    @Override
    public String toString() {
        return "Primitives.Vector{" +
                "origin=" + origin +
                '}';
    }

    @Override
    public int compareTo(Vector vector) {
        return this.origin.compareTo(vector.origin);
    }

}
