package Primitives;

/**
 * Created by Emmanuel Elnekave  on 20/03/2017.
 */

public class Point2D implements Comparable<Point2D>{

    protected Coordinate _x;
    protected Coordinate _y;

    public Point2D(){
        _x = new Coordinate();
        _y = new Coordinate();
    }

    public Point2D(Coordinate x, Coordinate y){
        _x = new Coordinate(x);
        _y = new Coordinate(y);
    }

    public Point2D(Point2D point2D){
        _x = point2D.getX();
        _y = point2D.getY();
    }

    public Coordinate getX() { return new Coordinate(_x); }

    public void setX(Coordinate _x) { this._x = new Coordinate(_x);	}

    public Coordinate getY() { return new Coordinate(_y); }

    public void setY(Coordinate _y) { this._y = new Coordinate(_y);	}

    @Override
    public int compareTo(Point2D point2D) {
        if (this._x.compareTo(point2D._x) == 0 && this._y.compareTo(point2D._y) == 0)
            return 0;

        return 1;
    }


}
