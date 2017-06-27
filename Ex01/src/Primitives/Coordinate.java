package Primitives;

/**
 * Created by Emmanuel Elnekave  on 20/03/2017.
 */

public class Coordinate implements Comparable<Coordinate>{

    private double _coordinate;

    // ***************** Constructors ********************** //

    public Coordinate()                      { this._coordinate = 0.0;                    }
    public Coordinate(double coordinate)     { this._coordinate = coordinate;             }
    public Coordinate(Coordinate coordinate) { this._coordinate = coordinate._coordinate; }

    // ***************** Getters/Setters ********************** //

    public double getCoordinate()                {	return _coordinate;	          }
    public void setCoordinate(double coordinate) { this._coordinate = coordinate; }

    // ***************** Administration  ******************** //

    @Override
    public int compareTo(Coordinate coordinate) {
        return Double.compare(this._coordinate, coordinate._coordinate);
    }

    // ***************** Operations ******************** //

    public void add (Coordinate coordinate ){
        this._coordinate += coordinate._coordinate;
    }

    public void subtract(Coordinate coordinate) {
        this._coordinate -= coordinate._coordinate;
    }

}
