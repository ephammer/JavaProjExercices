package UnitTests;

import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;
import org.junit.Test;

import java.awt.*;

/**
 * Created by ehammer on 26/06/2017.
 */
public class LightingTests {
    @Test
    public void emissionTest(){

        Scene scene = new Scene();
        scene.set_screenDistance(50);
        scene.addGeometry(
                new Sphere(
                        50,
                        new Point3D(0.0, 0.0, -50)));

        Triangle triangle = new Triangle(
                new Point3D( 100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D( 100, 100, -49));

        Triangle triangle2 = new Triangle(
                new Point3D( 100, 0, -49),
                new Point3D(  0, -100, -49),
                new Point3D( 100,-100, -49));
        triangle2.set_emission(new Color(50, 200, 50));

        Triangle triangle3 = new Triangle(
                new Point3D(-100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D(-100, 100, -49));
        triangle3.set_emission(new Color (50, 50, 200));

        Triangle triangle4 = new Triangle(
                new Point3D(-100, 0, -49),
                new Point3D(  0,  -100, -49),
                new Point3D(-100, -100, -49));
        triangle4.set_emission(new Color (200, 50, 50));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("emission_test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }



    @Test
    public void spotLightTest01(){

        Scene scene = new Scene();
        scene.set_screenDistance(200);
        Sphere sphere = new Sphere(
                500,
                new Point3D(0.0, 0.0, -1000));

        sphere.set_shininess(20);

        sphere.set_emission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(
                new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.set_emission(new Color (0, 0, 100));
        triangle.set_shininess(4);
        scene.addGeometry(triangle);

        scene.addLight(
                new Elements.SpotLight(
                        new Color(255, 100, 100),
                        new Point3D(-200, -200, -150),
                        new Vector(2, 2, -3),
                        0.1, 0.00001, 0.000005
                ));

        ImageWriter imageWriter = new ImageWriter("spot_light_test_01", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }


    @Test
    public void spotLightTest02(){

        Scene scene = new Scene();

        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));

        sphere.set_shininess(20);

        sphere.set_emission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        scene.addLight(new Elements.SpotLight(
                new Color(255, 100, 100),
                new Point3D(-200, -200, -100),
                new Vector(2, 2, -3),
                0, 0.00001, 0.000005)
        );

        ImageWriter imageWriter = new ImageWriter("spot_light_test_02", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void spotLightTest03(){

        Scene scene = new Scene();

        Triangle triangle = new Triangle(
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(
                new Elements.SpotLight(
                        new Color(255, 100, 100),
                        new Point3D(200, 200, -100),
                        new Vector(-2, -2, -3),
                        0, 0.000001, 0.0000005)
        );


        ImageWriter imageWriter = new ImageWriter("spot_light_test_03", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void pointLightTest01(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere (
                800,
                new Point3D(0.0, 0.0, -1000)
        );
        sphere.set_shininess(20);
        sphere.set_emission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(
                new PointLight(
                        new Color(255,100,100),
                        new Point3D(-200, -200, -100),
                        0, 0.00001, 0.000005)
        );

        ImageWriter imageWriter = new ImageWriter("point_light_test_01", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }

    @Test
    public void pointLightTest02(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(
                800,
                new Point3D(0.0, 0.0, -1000)
        );
        sphere.set_shininess(20);
        sphere.set_emission(new Color(0, 0, 100));

        Triangle triangle01 = new Triangle(
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle02 = new Triangle(
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle01);
        scene.addGeometry(triangle02);

        scene.addLight(
                new PointLight(
                        new Color(255, 100, 100),
                        new Point3D(200, 200, -100),
                        0, 0.000001, 0.0000005)
        );


        ImageWriter imageWriter = new ImageWriter("point_light_test_02", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void shadowTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.set_shininess(20);
        sphere.set_emission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(
                new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(
                new Elements.SpotLight(
                        new Color(255, 100, 100),
                        new Point3D(200, 200, -100),
                        new Vector(-2, -2, -3),
                        0, 0.000001, 0.0000005)
        );


        ImageWriter imageWriter = new ImageWriter("shadow_test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

}
