/**
 * Created by kid0n on 21/03/2017.
 */
public class Ray extends Vector {

    public Ray() {
        super();
    }

    public Ray(Point3D origin, Point3D point3D) {
        super(origin, point3D);
    }

    public  Ray(Ray ray)
    {
        setOrigin(ray.getOrigin());
        setPoint3D(ray.getPoint3D());
    }
}
