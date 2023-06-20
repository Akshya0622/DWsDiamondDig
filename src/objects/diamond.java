package objects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class diamond extends AllObjects {
    public diamond() throws IOException {
        objName = "diamond";
        image = ImageIO.read(new File("C:\\TwoD\\src\\images\\diamond.png"));
    }
}
