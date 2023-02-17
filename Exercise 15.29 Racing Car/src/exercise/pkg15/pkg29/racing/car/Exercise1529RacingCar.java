package exercise.pkg15.pkg29.racing.car;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ryley
 */
public class Exercise1529RacingCar extends Application {

    @Override
    public void start(Stage primaryStage) {
        //car
        Image image = new Image("car.png");
        ImageView car = new ImageView(image);
        
        //sun
        Image image2 = new Image("sun.png");
        ImageView sun = new ImageView(image2);
        sun.setLayoutX(500);
        sun.setLayoutY(-25);

        //Create pane and add nodes
        Pane pane = new Pane();
        pane.getChildren().addAll(car, sun);
        
        //Set PathTransition to animate car across scene
        PathTransition pt = new PathTransition(Duration.millis(10000),
        new Line(65, 320, 535, 320), car);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.play();

        //Create scene with pane and add stylesheet
        Scene scene = new Scene(pane, 600, 400);
        //stylesheet holds the background image
        scene.getStylesheets().add("stylesheet.css");
        primaryStage.setTitle("Race");
        primaryStage.setScene(scene);
        primaryStage.show();

        /*Controls
        *UP arrow key speeds up car :: can be held to repeat
        *DOWN arrow key slows down car to default speed :: can be held to repeat
        *SPACE PRESSED pauses car
        *SPACE RELEASED unpauses car
        */
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pt.setRate(pt.getCurrentRate() + 1);
            } else if (e.getCode() == KeyCode.DOWN && pt.getCurrentRate() > 1) {
                pt.setRate(pt.getCurrentRate() - 1);
            } else if (e.getCode() == KeyCode.SPACE) {
                pt.pause();
            }
        });
        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                pt.play();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
