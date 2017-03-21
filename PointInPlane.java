/**
 * Created by Emmanuel Elnekave on 20/03/2017.
 */
public class PointInPlane extends Coordinate{

    private double planePoint;

    public PointInPlane(){
        super(0);
        setPlanePoint(0);
    }

    public PointInPlane(double planePoint, double singlePoint) {

        super(singlePoint);
        try {
            setPlanePoint(planePoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PointInPlane(PointInPlane pointInPlane){
        try {
            pointInPlane.setSinglePoint(this.getSinglePoint());
            pointInPlane.setPlanePoint(this.getPlanePoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getPlanePoint() {
        return planePoint;
    }

    public void setPlanePoint(double planePoint) {
        this.planePoint = planePoint;
    }

    public String toString(){
        return super.toString() + "point in plane: " + this.getPlanePoint();
    }

}
