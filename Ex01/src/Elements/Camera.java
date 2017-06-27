package Elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.Map;

/**
 * Created by ephammer on 15/06/2017.
 */
public class Camera {
    private Point3D _P0;
    private Vector _vUp;
    private Vector _vTo;
    private Vector _vRight;

    public Camera() {

        _P0 = new Point3D(0, 0, 10);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);

        _vRight = _vUp.crossProduct(_vTo);
    }

    public Camera(Point3D _P0, Vector _vUp, Vector _vTo) {
        this._P0 = new Point3D(_P0);
        this._vUp = new Vector(_vUp);
        this._vTo = new Vector(_vTo);

        _vRight = _vUp.crossProduct(_vTo);
        this._vUp = _vTo.crossProduct(_vRight);

        this._vUp.normalize();
        this._vTo.normalize();
        this._vRight.normalize();
    }

    public Camera (Map<String, String> attributes){

        String[] P0params = attributes
                .get("P0").split("\\s+");

        _P0 = new Point3D(Double.valueOf(P0params[0]),
                Double.valueOf(P0params[1]),
                Double.valueOf(P0params[2]));

        String[] vToParam = attributes
                .get("vTo").split("\\s+");
        _vTo = new Vector(Double.valueOf(vToParam[0]),
                Double.valueOf(vToParam[1]),
                Double.valueOf(vToParam[2]));

        String[] vUpParam =  attributes
                .get("vUp").split("\\s+");
        _vUp = new Vector(Double.valueOf(vUpParam[0]),
                Double.valueOf(vUpParam[1]),
                Double.valueOf(vUpParam[2]));

        _vRight = _vUp.crossProduct(_vTo);
        _vUp = _vTo.crossProduct(_vRight);

        _vUp.normalize();
        _vTo.normalize();
        _vRight.normalize();


    }


    public Camera (Camera camera){

        _P0     = camera.get_P0();
        _vUp    = camera.get_vUp();
        _vTo    = camera.get_vTo();
        _vRight = camera.get_vRight();

    }

    public Point3D get_P0() {
        return new Point3D(_P0);
    }

    public void set_P0(Point3D _P0) {
        this._P0 = new Point3D(_P0);
    }

    public Vector get_vUp() {
        return new Vector(_vUp);
    }

    public void set_vUp(Vector _vUp) {
        this._vUp = new Vector(_vUp);
    }

    public Vector get_vTo() {
        return new Vector(_vTo);
    }

    public void set_vTo(Vector _vTo) {
        this._vTo = new Vector(_vTo);
    }

    public Vector get_vRight() {
        return new Vector(_vRight);
    }

    public void set_vRight(Vector _vRight) {
        this._vRight = new Vector(_vRight);
    }

    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        Vector vToward = new Vector(_vTo);
        vToward.scale(screenDistance);

        Point3D Pc = new Point3D(_P0);
        Pc.add(vToward);

        double Rx = screenWidth  / Nx;
        double Ry = screenHeight / Ny;

        Vector vRight = new Vector(_vRight);
        Vector vUp = new Vector(_vUp);

        vRight.scale(((x - (Nx/2.0)) * Rx + 0.5 * Rx));
        vUp.scale(((y - (Ny/2.0)) * Ry + 0.5 * Ry));

        vRight.subtract(vUp);

        Pc.add(vRight);

        Point3D P = new Point3D(Pc);

        Vector ray = new Vector(_P0, P);
        ray.normalize();

        return new Ray(P, ray);

    }

}
