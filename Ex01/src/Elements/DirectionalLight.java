package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

/**
 * Created by ehammer on 19/06/2017.
 */
public class DirectionalLight extends Light implements LightSource{

    private Vector _direction;

    public DirectionalLight(Color color, Vector direction){
        super (color);
        _direction = new Vector(direction);
    }

    public Color getIntensity(Point3D point)
    {
        return getIntensity();
    }
    public Vector getL(Point3D point)
    {
        return get_direction();
    }

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }
}
