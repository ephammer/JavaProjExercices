package Primitives;

/**
 * Created by ephammer on 21/03/2017.
 */
public class Ray extends Vector {

    private Point3D _POO;

    private Vector _direction;

    public Ray() {
        this._POO = new Point3D();
        this._direction = new Vector(_direction);

    }

    public Ray(Point3D origin, Point3D point3D) {
        super(origin, point3D);
    }

    public  Ray(Ray ray)
    {
        this._POO = ray.get_POO();
        this._direction = ray.get_direction();

    }
    public Ray(Point3D _POO, Vector direction){
        this._POO = new Point3D(_POO);
        this._direction = new Vector (direction);
        this._direction.normalize();
    }

    public Point3D get_POO() {
        return new Point3D(_POO);
    }

    public void set_POO(Point3D _POO) {
        this._POO = new Point3D(_POO);
    }

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction = new Vector(_direction);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "_POO=" + _POO +
                ", _direction=" + _direction +
                '}';
    }
}