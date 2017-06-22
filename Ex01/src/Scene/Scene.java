package Scene;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.LightSource;
import Geometries.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ehammer on 19/06/2017.
 */
public class Scene {

    private Color _background;
    private AmbientLight _ambientLight;
    private List<Geometry> _geometries = new ArrayList<Geometry>();
    private Camera _camera;
    private double _screenDistance;
    private List<LightSource> _lights = new ArrayList<LightSource>();

    private String _sceneName = "scene";

    public Scene(){
        _background = new Color(0, 0, 0);
        _ambientLight = new AmbientLight();
        set_camera(new Camera());
        _screenDistance = 100;
    }

    public Scene (Scene scene){
        _background = scene.get_background();
        _ambientLight = scene.get_ambientLight();
        _geometries = scene._geometries;
        _lights = scene._lights;
        _camera = scene.get_camera();
        _screenDistance = scene._screenDistance;
    }

    public Scene(AmbientLight aLight, Color background,
                 Camera camera, double screenDistance){

        _background = background;
        _ambientLight = new AmbientLight(aLight);
        set_camera(new Camera(camera));
        _screenDistance = screenDistance;
    }

    public Color get_background() {
        return _background;
    }

    public void set_background(Color _background) {
        this._background = _background;
    }

    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public List<Geometry> get_geometries() {
        return _geometries;
    }

    public void set_geometries(List<Geometry> _geometries) {
        this._geometries = _geometries;
    }

    public Camera get_camera() {
        return _camera;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    public double get_screenDistance() {
        return _screenDistance;
    }

    public void set_screenDistance(double _screenDistance) {
        this._screenDistance = _screenDistance;
    }

    public String get_sceneName() {
        return _sceneName;
    }

    public void set_sceneName(String _sceneName) {
        this._sceneName = _sceneName;
    }

    public void addGeometry(Geometry geometry){
        _geometries.add(geometry);
    }

    public Iterator<Geometry> getGeometriesIterator(){
        return _geometries.iterator();
    }

    public void addLight(LightSource light){
        _lights.add(light);
    }

    public Iterator<LightSource> getLightsIterator(){
        return _lights.iterator();
    }

}
