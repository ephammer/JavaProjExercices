package UnitTests;

import Elements.Camera;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ehammer on 26/06/2017.
 */
public class TriangleTest {
    @Test
    public void findIntersections() throws Exception {

        final int WIDTH  = 3;
        final int HEIGHT = 3;

        Ray[][] rays = new Ray [HEIGHT][WIDTH];

        Camera camera = new Camera(
                new Point3D(0.0 ,0.0 ,0.0),
                new Vector(0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0) );

        Triangle triangle1 = new Triangle(
                new Point3D( 0,  1, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2) );

        Triangle triangle2 = new Triangle(
                new Point3D( 0,  10, -2),
                new Point3D( 1, -1, -2),
                new Point3D(-1, -1, -2) );

        List<Point3D> intersectionPointsTriangle1 = new ArrayList<>();
        List<Point3D> intersectionPointsTriangle2 = new ArrayList<>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH,
                        HEIGHT,
                        j,
                        i,
                        1,
                        3 * WIDTH,
                        3 * HEIGHT );

                List<Point3D> rayIntersectionPoints   = triangle1.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2  = triangle2.FindIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints)
                    intersectionPointsTriangle1.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsTriangle2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsTriangle1.size() == 1);
        assertTrue(intersectionPointsTriangle2.size() == 2);

        System.out.println("Intersection Points:");
        for (Point3D iPoint: intersectionPointsTriangle1){
            System.out.println(iPoint);
        }
        System.out.println("--");
        for (Point3D iPoint: intersectionPointsTriangle2){
            System.out.println(iPoint);
        }

    }

}