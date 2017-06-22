package Elements;

import java.awt.*;

/**
 * Created by ehammer on 19/06/2017.
 */
public class Light {

    protected Color _color;

    public Light()
    {
        _color = null;
    }
    public Light (Color color)
    {
        _color = color;
    }

    public Color getIntensity()
    {
        return _color;
    }

}
