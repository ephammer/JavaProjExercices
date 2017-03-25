/**
 * Created by kid0n on 21/03/2017.
 */
public class Main {


    public static void main(String[] args) {

        // TODO: Create instances of dfierent classes for test purposes
        Coordinate x = new Coordinate();
        Coordinate y = new Coordinate(2.5);
        Coordinate z = new Coordinate(7);

        Coordinate p, q, r;
        p = new Coordinate(1);
        q = new Coordinate(y);
        r = new Coordinate(6.3);

        Point2D xy = new Point2D(x,y);

        Point3D xyz = new Point3D(x,y,z);
        Point3D pqr = new Point3D(1,2.5,6.3);

        Vector v = new Vector(xyz,pqr);

        Coordinate[] cArray = new Coordinate[6];
        cArray[0] = x;
        cArray[1] = y;
        cArray[2] = z;
        cArray[3] = p;
        cArray[4] = q;
        cArray[5] = r;

        for(Coordinate c : cArray)
        {
            System.out.println(c.toString());
        }

        System.out.println(xy.toString());
        System.out.println(xyz.toString());
        System.out.println(pqr.toString());
        System.out.println(v.toString());


    }
}
