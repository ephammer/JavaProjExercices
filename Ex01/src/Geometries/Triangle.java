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
public class Triangle extends Geometry{
    Point3D _p1;
    Point3D _p2;
    Point3D _p3;

    public Triangle(){

        _p1 = new Point3D();
        _p2 = new Point3D();
        _p3 = new Point3D();
    }

    public Triangle(Triangle triangle){
        _p1 = triangle.get_p1();
        _p2 = triangle.get_p2();
        _p3 = triangle.get_p3();
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) {
        this._p1 = _p1;
        this._p2 = _p2;
        this._p3 = _p3;
    }

    public Triangle(Map<String, String> attributes){

        String[] P0coordinates = attributes
                .get("P0" ).split("\\s+");

        _p1 = new Point3D(Double.valueOf(P0coordinates[0]),
                Double.valueOf(P0coordinates[1]),
                Double.valueOf(P0coordinates[2]));

        String[] P1coordinates = attributes
                .get("P1" ).split("\\s+");

        _p2 = new Point3D(Double.valueOf(P1coordinates[0]),
                Double.valueOf(P1coordinates[1]),
                Double.valueOf(P1coordinates[2]));

        String[] P2coordinates = attributes
                .get("P2" ).split("\\s+");

        _p3 = new Point3D(Double.valueOf(P2coordinates[0]),
                Double.valueOf(P2coordinates[1]),
                Double.valueOf(P2coordinates[2]));

    }


    public Point3D get_p1() {
        return _p1;
    }

    public void set_p1(Point3D _p1) {
        this._p1 = _p1;
    }

    public Point3D get_p2() {
        return _p2;
    }

    public void set_p2(Point3D _p2) {
        this._p2 = _p2;
    }

    public Point3D get_p3() {
        return _p3;
    }

    public void set_p3(Point3D _p3) {
        this._p3 = _p3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "_p1=" + _p1 +
                ", _p2=" + _p2 +
                ", _p3=" + _p3 +
                '}';
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionPoints = new ArrayList<Point3D>(1);

        // Intersecting the triangular plane

        Point3D P0 = ray.get_POO();

        Vector N = getNormal(null);
        Plane plane = new Plane(N, _p3);

        if (plane.FindIntersections(ray).isEmpty())
            return intersectionPoints;

        Point3D intersectionPlane = plane.FindIntersections(ray).get(0);

        // Checking if the interseculating point is bounded by the triangle
        Vector P_P0 = new Vector(P0, intersectionPlane);

        // Checking 1/3 triangular side
        Vector V1_1 = new Vector(P0, this._p1);
        Vector V2_1 = new Vector(P0, this._p2);
        Vector N1 = V1_1.crossProduct(V2_1);
        N1.narmol();
        double S1 = -P_P0.dotProduct(N1);

        // Checking 2/3 triangular side
        Vector V1_2 = new Vector(P0, this._p2);
        Vector V2_2 = new Vector(P0, this._p3);
        Vector N2 = V1_2.crossProduct(V2_2);
        N2.narmol();
        double S2 = -P_P0.dotProduct(N2);

        // Checking 1/3 triangular side
        Vector V1_3 = new Vector(P0, this._p3);
        Vector V2_3 = new Vector(P0, this._p1);
        Vector N3 = V1_3.crossProduct(V2_3);
        N3.narmol();
        double S3 = -P_P0.dotProduct(N3);

        if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                ((S1 < 0) && (S2 < 0) && (S3 < 0))){
            intersectionPoints.add(intersectionPlane);
        }

        return intersectionPoints;

    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector U = new Vector (_p1, _p2);
        Vector V = new Vector (_p1, _p3);
        Vector N = new Vector (U.crossProduct(V));

        N.narmol();
        N.scalarMult(-1);
        return N;

    }
}
