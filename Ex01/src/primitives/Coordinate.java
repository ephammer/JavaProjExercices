package primitives;

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
            this.setPoint(coordinate.getPoint());
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

    public int compareTo(Coordinate coordinate)
    {
        if (this.getPoint() == coordinate.getPoint())   return 0;
        else if (this.getPoint() < coordinate.getPoint())   return -1;
        else return 1;
    }

    public Coordinate add(Coordinate coordinate)
    {
        point += coordinate.getPoint();

        return this;
    }

    public Coordinate Substrct(Coordinate coordinate)
    {
        point -= coordinate.getPoint();
        return this;
    }
}
