import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class image extends Application {
    /*
    public static void main(String[] args) {
        launch(args);
    }
    */
    @Override
    public void start(Stage stage) {

        Image image = new Image("calstpark.jpg");

        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitWidth(600);
        iv.setPreserveRatio(true);

        ImageView iv2 = new ImageView();
        iv2.setImage(image);
        iv2.setFitWidth(100);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);

        ImageView iv3 = new ImageView();
        iv3.setImage(image);
        iv3.setFitWidth(200);
        iv3.setPreserveRatio(true);
        Rectangle2D viewportRect = new Rectangle2D(600, 135, 2110, 1810);
        iv3.setViewport(viewportRect);
        //iv3.setRotate(90);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().add(iv);
        box.getChildren().add(iv2);
        box.getChildren().add(iv3);
        root.getChildren().add(box);

        stage.setTitle("Imageviewer");
        stage.setWidth(415);
        stage.setHeight(200);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
