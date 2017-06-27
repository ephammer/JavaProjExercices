package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ephammer on 15/06/2017.
 */
public class Plane extends Geometry {

    Vector _normal;
    Point3D _Q;

    public Plane(){
        _normal = new Vector();
        _Q = new Point3D();
    }

    public Plane (Plane plane){
        _normal = plane.get_normal(null);
        _Q = plane.get_Q();
    }

    public Plane (Vector normal, Point3D q){
        _normal = new Vector(normal);
        _normal.normalize();
        _Q = new Point3D(q);
    }

    public Point3D get_Q() {
        return new Point3D(_Q);
    }

    public void set_Q(Point3D _Q) {
        this._Q = new Point3D(_Q);
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoint = new ArrayList<>(1);

        Point3D P0 = ray.get_POO();
        Point3D Q0 = this.get_Q();
        Vector N = this.get_normal(null);
        Vector V = ray.get_direction();

        Vector v = new Vector (Q0, P0);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0){
            V.scale(t);
            P0.add(V);
            intersectionPoint.add(P0);
        }

        return intersectionPoint;
    }

    @Override
    public Vector get_normal(Point3D point) {
        return new Vector(_normal);
    }
}
