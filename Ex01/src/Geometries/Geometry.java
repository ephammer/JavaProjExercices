package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ephammer on 21/03/2017.
 */
public abstract class Geometry {

    private Material _material = new Material();

    private Color _emmission = new Color(0, 0, 0);

    public Color get_emmission() {
        return _emmission;
    }

    public void set_emmission(Color _emmission) {
        this._emmission = _emmission;
    }

    public Material get_material() {
        return _material;
    }

    public void set_material(Material _material) {
        this._material = _material;
    }

    public abstract List<Point3D> FindIntersections (Ray ray);

    public abstract Vector getNormal(Point3D point);

}
