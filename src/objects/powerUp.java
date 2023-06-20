package objects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class powerUp extends AllObjects {
    public powerUp() throws IOException {
        objName = "diamond";
        image = ImageIO.read(new File("C:\\TwoD\\src\\images\\powerup.png"));
    }
}
