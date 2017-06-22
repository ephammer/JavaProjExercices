package Elements;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

/**
 * Created by ehammer on 15/06/2017.
 */
public class Camera {
    Point3D _P0;
    Vector _vUp;
    Vector _vTo;
    Vector _vRight;

    public Camera() {
        _P0 = new Point3D(0, 0, 10);
        _vUp = new Vector(1.0, 0.0, 0.0);
        _vTo = new Vector(0.0, 0.0, -1.0);

        _vRight = _vUp.crossProduct(_vTo);


    }
    public Camera(Point3D _P0, Vector _vUp, Vector _vTo) {
        this._P0 = _P0;
        this._vUp = _vUp;
        this._vTo = _vTo;
        this._vRight = _vUp.crossProduct(_vTo);
    }

    public Camera (Camera camera){
        _P0     = camera.get_P0();
        _vUp    = camera.get_vUp();
        _vTo    = camera.get_vTo();
        _vRight = camera.get_vRight();
    }

    public Point3D get_P0() {
        return _P0;
    }

    public void set_P0(Point3D _P0) {
        this._P0 = _P0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public void set_vUp(Vector _vUp) {
        this._vUp = _vUp;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public void set_vTo(Vector _vTo) {
        this._vTo = _vTo;
    }

    public Vector get_vRight() {
        return _vRight;
    }

    public void set_vRight(Vector _vRight) {
        this._vRight = _vRight;
    }

    public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        // Calculating the image center
        Vector vToward = new Vector(_vTo);
        vToward.scalarMult(screenDistance);

        Point3D Pc = new Point3D(_P0);
        Pc.add(vToward);

        // Calculating x-y ratios
        double Rx = screenWidth  / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        Vector vRight = new Vector(_vRight);
        Vector vUp = new Vector(_vUp);

        vRight.scalarMult(((x - (Nx/2.0)) * Rx + 0.5 * Rx));
        vUp.scalarMult(((y - (Ny/2.0)) * Ry + 0.5 * Ry));

        vRight.Substrct(vUp);

        Pc.add(vRight);

        Point3D P = new Point3D(Pc);

        // constructing ray between P0 and the intersection point
        Vector ray = new Vector(_P0, P);
        ray.narmol();

        // returning the constructed ray
        return new Ray(P, ray);

    }

}
