import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
public class basicCVFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WritableImage writableImage = loadImage();

        //Setting the image view
        ImageView imageView = new ImageView(writableImage);
        imageView.setX(50);
        imageView.setY(25);
        imageView.setFitHeight(400);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView);
        //Creating a scene object
        Scene scene = new Scene(root, 600, 400);
        //Setting title to the Stage
        stage.setTitle("Loading an image");
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
    }
    public WritableImage loadImage() throws IOException {
        //Loading the OpenCV core library
        //System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

        //Reading the Image from the file and storing it in to a Matrix object
        String file = "src\\calstpark.jpg";

        Mat image = Imgcodecs.imread(file);
        //Encoding the image
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", image, matOfByte);

        //Storing the encoded Mat in a byte array
        byte[] byteArray = matOfByte.toArray();

        //Displaying the image
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage bufImage = ImageIO.read(in);

        System.out.println("Image Loaded");
        WritableImage writableImage = SwingFXUtils.toFXImage(bufImage, null);
        return writableImage;
    }

    public static void main(String args[]) {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        launch(args);

    }




}