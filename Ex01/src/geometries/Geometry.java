package geometries;

import java.awt.Color;
import primitives.Vector;

/**
 * Created by kid0n on 21/03/2017.
 */
public class Geometry {

    public Geometry() {
        this.mColor = Color.white;
    }

    public Geometry(Color mColor) {
        this.mColor = mColor;
    }

    public Geometry(Geometry geometry) {
        geometry.setmColor(this.getmColor());
    }

    private Color mColor;

    public Color getmColor() {
        return mColor;
    }

    public void setmColor(Color mColor) {
        this.mColor = mColor;
    }

    public Vector getNormal(Vector vector)
    {
        return vector.narmol();
    }
}
