package Primitives;

/**
 * Created by Emmanuel Elnekave on 20/03/2017.
 */
public class Coordinate implements Comparable<Coordinate> {

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
        return "Primitives.Coordinate{" +
                "point=" + point +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        return Double.compare(that.getPoint(), getPoint()) == 0;
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

    @Override
    public int compareTo(Coordinate coordinate) {
        return Double.compare(this.point, coordinate.point);
    }
}
