/**
 * Created by Emmanuel Elnekave on 20/03/2017.
 */
public class Coordinate {

    private double point;

    public Coordinate()
    {
        setPoint(0);
    }

    public Coordinate(double point) {
        try {
            setPoint(point);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Coordinate(Coordinate coordinate){
        try
        {
            coordinate.setPoint(this.getPoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        try {
            this.point = point;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "point=" + point +
                '}';
    }
}
