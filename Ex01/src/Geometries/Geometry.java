package Geometries;

import Primitives.Vector;

import java.awt.*;

/**
 * Created by kid0n on 21/03/2017.
 */
public class Geometry {

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

    @Override
    public String toString() {
        return "Geometries.Geometry{" +
                "mColor=" + mColor +
                '}';
    }
}
