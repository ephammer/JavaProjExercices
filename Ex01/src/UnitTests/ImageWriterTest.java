package UnitTests;

import Renderer.ImageWriter;
import org.junit.Test;

/**
 * Created by ehammer on 26/06/2017.
 */
public class ImageWriterTest {
    @Test
    public void writeImageTest(){

        ImageWriter imageWriter = new ImageWriter("image_writer_test", 500, 500, 1, 1);

        for (int i = 0; i < imageWriter.getHeight(); i++){
            for (int j = 0; j < imageWriter.getWidth(); j++){

                if (i % 50 == 0 || j % 50 == 0)
                    imageWriter.writePixel(j, i, 255, 255, 255);

            }
        }

        imageWriter.writeToimage();

    }


}