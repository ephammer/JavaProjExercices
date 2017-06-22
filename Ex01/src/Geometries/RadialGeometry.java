package Geometries;

/**
 * Created by ehammer on 19/06/2017.
 */
public abstract class RadialGeometry extends Geometry{

    protected double _radius;

    public RadialGeometry(){
        this._radius = 0.0;
    }
    public RadialGeometry(double radius){
        this._radius = radius;
    }

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }
}
