/**
 * Created by kid0n on 21/03/2017.
 */
public class Vector {

    private Point3D origin;
    private Point3D point3D;

    public Vector(Point3D point3D) {
        this.point3D = point3D;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;

        Vector vector = (Vector) o;

        return getPoint3D() != null ? getPoint3D().equals(vector.getPoint3D()) : vector.getPoint3D() == null;
    }

}
