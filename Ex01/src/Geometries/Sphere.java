package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ephammer on 15/06/2017.
 */
public class Sphere extends RadialGeometry {
    Point3D _center;

    public Sphere (Sphere sphere){
        super(sphere._radius);
        _center = sphere.get_center();
    }

    public Sphere(double radius, Point3D center){
        super(radius);
        _center = new Point3D(center);
    }

    public Sphere(Map<String, String> attributes){

        String[] centerPoints = attributes
                .get("center" ).split("\\s+");

        _center = new Point3D(Double.valueOf(centerPoints[0]),
                Double.valueOf(centerPoints[1]),
                Double.valueOf(centerPoints[2]));

        _radius = Double.valueOf(attributes.get("radius"));
    }

    public Point3D get_center() {
        return new Point3D(_center);
    }

    public void set_center(Point3D _center) {
        this._center =  new Point3D(_center);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                '}';
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoints= new ArrayList<>(2);

        Vector L = new Vector(ray.get_POO(), this.get_center());
        double tm = L.dotProduct(ray.get_direction());
        double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));

        if (d > this.get_radius())
            return intersectionPoints;

        double th = Math.sqrt(Math.pow(this.get_radius(), 2) - Math.pow(d, 2));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0){
            Vector V = ray.get_direction();
            V.scale(t1);
            Point3D P1 = ray.get_POO();
            P1.add(V);
            intersectionPoints.add(P1);
        }

        if (t2 >= 0){
            Vector V = ray.get_direction();
            V.scale(t2);
            Point3D P2 = ray.get_POO();
            P2.add(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;
    }

    @Override
    public Vector get_normal(Point3D point) {

        Vector N = new Vector (_center, point);
        N.normalize();
        return N;
    }
}
