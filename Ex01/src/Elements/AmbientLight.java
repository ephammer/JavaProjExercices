package Elements;

import java.awt.*;
import java.util.Map;

/**
 * Created by ephammer on 19/06/2017.
 */
public class AmbientLight extends Light{

    private final double _ka = 0.1;

    public AmbientLight() {
        super(new Color(255, 255, 255));
    }

    public AmbientLight(AmbientLight aLight){
        super(aLight._color);
    }

    public AmbientLight(int r, int g, int b) {
        super(new Color(r, g, b));
    }

    public AmbientLight(Map<String, String> attributes){
        String[] ambientLightColors = attributes
                .get("color" ).split("\\s+");
        _color = new Color((int)(255 * Double.valueOf(ambientLightColors[0])),
                (int)(255 * Double.valueOf(ambientLightColors[1])),
                (int)(255 * Double.valueOf(ambientLightColors[2])));
    }

    public Color getColor()             { return _color;  }
    public void  setColor(Color color)  { _color = color; }
    public double get_ka()				{ return _ka;     }

    public Color getIntensity() {
        return new Color(
                (int)(_color.getRed()   * _ka),
                (int)(_color.getGreen() * _ka),
                (int)(_color.getBlue()  * _ka) );
    }


    @Override
    public String toString() {
        return "AmbientLight{" +
                "_ka=" + _ka +
                '}';
    }
}
