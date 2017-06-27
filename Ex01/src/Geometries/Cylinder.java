package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

/**
 * Created by ephammer on 15/06/2017.
 */
public class Cylinder extends RadialGeometry{

    Point3D _axisPoint;
    Vector _axisDirection;

    public Cylinder(){
        super(0.0);
        _axisPoint = new Point3D();
        _axisDirection = new Vector();
    }

    public Cylinder(Cylinder cylinder){
        super(cylinder._radius);
        _axisPoint = cylinder.get_axisPoint();
        _axisDirection = cylinder.get_axisDirection();
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
        super(radius);
        _axisPoint = new Point3D(axisPoint);
        _axisDirection = new Vector(axisDirection);
    }


    public Point3D get_axisPoint() {
        return new Point3D(_axisPoint);
    }

    public void set_axisPoint(Point3D _axisPoint) {
        this._axisPoint = new Point3D(_axisPoint);
    }

    public Vector get_axisDirection() {
        return new Vector(_axisDirection);
    }

    public void set_axisDirection(Vector _axisDirection) {
        this._axisDirection = new Vector(_axisDirection);
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        return null;
    }

    @Override
    public Vector get_normal(Point3D point) {
        return null;
    }
}
