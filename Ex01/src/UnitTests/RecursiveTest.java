package UnitTests;

import Elements.*;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import org.junit.Test;

import java.awt.*;

/**
 * Created by ehammer on 26/06/2017.
 */
public class RecursiveTest {

    @Test
    public void recursiveTest01(){

        // Generating Scene
        Scene scene = new Scene();
        scene.set_screenDistance(300);

        // Adding the first sphere to the scene
        Sphere sphere01 = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere01.set_shininess(20);
        sphere01.set_emission(new Color(0, 0, 100));
        sphere01.get_material().set_Kt(0.5);
        scene.addGeometry(sphere01);

        // Adding the second sphere to the scene
        Sphere sphere02 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere02.set_shininess(20);
        sphere02.set_emission(new Color(100, 20, 20));
        sphere02.get_material().set_Kt(0);
        scene.addGeometry(sphere02);

        // Add a spotlight to the scene
        scene.addLight(
                new SpotLight(
                        new Color(255, 100, 100),
                        new Point3D(-200, -200, -150),
                        new Vector(2, 2, -3),
                        0.1,
                        0.00001,
                        0.000005)
        );

        // Generating an image
        ImageWriter imageWriter = new ImageWriter("recursive_test_01", 500, 500, 500, 500);

        // Render the scene on the image
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();

    }


    @Test
    public void recursiveTest02(){

        // Generating Scene
        Scene scene = new Scene();
        scene.set_screenDistance(300);

        // Adding the first sphere to the scene
        Sphere sphere01 = new Sphere(300, new Point3D(-550, -500, -1000));
        sphere01.set_shininess(20);
        sphere01.set_emission(new Color(0, 0, 100));
        sphere01.get_material().set_Kt(0.5);
        scene.addGeometry(sphere01);

        // Adding the second sphere to the scene
        Sphere sphere02 = new Sphere(150, new Point3D(-550, -500, -1000));
        sphere02.set_shininess(20);
        sphere02.set_emission(new Color(100, 20, 20));
        sphere02.get_material().set_Kt(0);
        scene.addGeometry(sphere02);

        // Generating the first triangle
        Triangle triangle01 = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D(  200,  200, -375));

        // Generating the second triangle
        Triangle triangle02 = new Triangle(new Point3D(  1500, -1500, -1500),
                new Point3D( -1500,  1500, -1500),
                new Point3D( -1500, -1500, -1500));

        // Set Emission and Material for both triangles
        triangle01.set_emission(new Color(20, 20, 20));
        triangle02.set_emission(new Color(20, 20, 20));
        triangle01.get_material().set_Kr(1);
        triangle02.get_material().set_Kr(0.5);

        // Add both triangles to scene
        scene.addGeometry(triangle01);
        scene.addGeometry(triangle02);

        // Add spotlight to scene
        scene.addLight(
                new SpotLight(
                        new Color(255, 100, 100),
                        new Point3D(200, 200, -150),
                        new Vector(-2, -2, -3),
                        0,
                        0.00001,
                        0.000005)
        );

        // Generating an image
        ImageWriter imageWriter = new ImageWriter("recursive_test_02", 500, 500, 500, 500);

        // Render the scene on the image
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void recursiveTest03(){

        // Generating Scene
        Scene scene = new Scene();
        scene.set_screenDistance(300);

        Sphere sphere01 = new Sphere(300, new Point3D(0, 0, -1000));
        sphere01.set_shininess(20);
        sphere01.set_emission(new Color(0, 0, 100));
        sphere01.get_material().set_Kt(0.5);
        scene.addGeometry(sphere01);

        Sphere sphere02 = new Sphere(150, new Point3D(0, 0, -1000));
        sphere02.set_shininess(20);
        sphere02.set_emission(new Color(100, 20, 20));
        sphere02.get_material().set_Kt(0);
        scene.addGeometry(sphere02);

        Triangle triangle01 = new Triangle(
                new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D(  700,  700, -375));

        Triangle triangle02 = new Triangle(
                new Point3D(  2000, -1000, -1500),
                new Point3D( -1000,  2000, -1500),
                new Point3D( -1000, -1000, -1500));

        triangle01.set_emission(new Color(20, 20, 20));
        triangle02.set_emission(new Color(20, 20, 20));
        triangle01.get_material().set_Kr(1);
        triangle02.get_material().set_Kr(0.5);
        scene.addGeometry(triangle01);
        scene.addGeometry(triangle02);

        scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150),
                new Vector(-2, -2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("recursive_test_03", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

}
