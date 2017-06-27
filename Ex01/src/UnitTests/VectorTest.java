package UnitTests;

import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by ehammer on 26/06/2017.
 */
public class VectorTest {

    @Test
    public void add() throws Exception {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.add(v2);
        assertTrue(v1.compareTo(new Vector(0.0,0.0,0.0)) == 0);

        v2.add(v1);
        assertTrue(v2.compareTo(v2) == 0);
    }

    @Test
    public void substrct() throws Exception {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.0);

        v1.subtract(v2);
        assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);

        v2.subtract(v1);
        assertTrue(v2.compareTo(new Vector(-3.0,-3.0,-3.0)) == 0);
    }

    @Test
    public void scalarMult() throws Exception {
        Vector v1 = new Vector(1.0, 1.0, 1.0);

        v1.scale(1);
        assertTrue(v1.compareTo(v1) == 0);

        v1.scale(2);
        assertTrue(v1.compareTo(new Vector(2.0,2.0,2.0)) == 0);

        v1.scale(-2);
        assertTrue(v1.compareTo(new Vector(-4.0,-4.0,-4.0)) == 0);
    }

    @Test
    public void length() throws Exception {
        Vector v = new Vector(3.5,-5,10);
        assertTrue(v.length() ==
                Math.sqrt(12.25 + 25 + 100));
    }

    @Test
    public void narmol() throws Exception {
        Vector v = new Vector(3.5,-5,10);
        v.normalize();
        assertEquals("", 1, v.length(),1e-10);

        v = new Vector(0,0,0);

        try {
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (ArithmeticException e) {
            assertTrue(true);
        }
    }

    @Test
    public void crossProduct() throws Exception {
        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5,7,0.5);
        Vector v3 = v1.crossProduct(v2);

        assertEquals("", 0, v3.dotProduct(v2), 1e-10);
        assertEquals("", 0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);
        v3.add(v4);
        assertEquals("", 0, v3.length(), 1e-10);
    }

    @Test
    public void dotProduct() throws Exception {
        Vector v1 = new Vector(3.5,-5,10);
        Vector v2 = new Vector(2.5,7,0.5);

        assertTrue(Double.compare(v1.dotProduct(v2), (8.75 + -35 + 5)) == 0);
    }

}