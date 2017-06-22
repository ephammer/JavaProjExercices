package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

/**
 * Created by ephammer on 19/06/2017.
 */
public interface LightSource {
    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point);
}
