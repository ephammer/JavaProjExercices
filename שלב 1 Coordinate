/**
 * Created by Emmanuel Elnekave on 20/03/2017.
 */
public class Coordinate {

    private double singlePoint;

    public Coordinate()
    {
        setSinglePoint(0);
    }

    public Coordinate(double singlePoint) {
        try {
            setSinglePoint(singlePoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Coordinate(Coordinate coordinate){
        try
        {
            coordinate.setSinglePoint(this.getSinglePoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double getSinglePoint() {
        return singlePoint;
    }

    public void setSinglePoint(double singlePoint) {
        try {
            this.singlePoint = singlePoint;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString()
    {
        return "single point: " + getSinglePoint();
    }
}
