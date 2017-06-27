package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;

/**
 * Created by ephammer on 21/03/2017.
 */
public abstract class Geometry {

    private Material _material = new Material();
    private double _shininess = 1;
    private Color _emission = new Color(0, 0, 0);

    public double get_shininess() {
        return _shininess;
    }

    public void set_shininess(double _shininess) {
        this._shininess = _shininess;
    }

    public Color get_emission() {
        return _emission;
    }

    public void set_emission(Color _emission) {
        this._emission = _emission;
    }

    public Material get_material() {
        return _material;
    }

    public void set_material(Material _material) {
        this._material = _material;
    }

    public abstract List<Point3D> FindIntersections (Ray ray);

    public abstract Vector get_normal(Point3D point);

    public void set_Ks(double ks) { _material.set_Ks(ks); }
    public void set_Kd(double kd) { _material.set_Kd(kd); }
    public void set_Kr(double Kr) { _material.set_Kr(Kr); }
    public void set_Kt(double Kt) { _material.set_Kt(Kt); }

}
