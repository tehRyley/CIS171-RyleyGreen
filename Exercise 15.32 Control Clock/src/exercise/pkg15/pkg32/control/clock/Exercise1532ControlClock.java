package exercise.pkg15.pkg32.control.clock;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Ryley
 */
public class Exercise1532ControlClock extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create clock
        ClockPane clock = new ClockPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(clock);

        //Create and adjust Stop/Start buttons
        Button btnStop = new Button("Stop");
        Button btnStart = new Button("Start");
        HBox btnBox = new HBox();
        btnBox.getChildren().addAll(btnStop, btnStart);
        borderPane.setBottom(btnBox);
        btnBox.setAlignment(Pos.CENTER);
        btnBox.setSpacing(5);
        Font font = Font.font(" ", FontWeight.BOLD, 15);
        btnStop.setFont(font);
        btnStart.setFont(font);

        //Set on click for buttons
        btnStop.setOnAction(e -> clock.pause());
        btnStart.setOnAction(e -> clock.play());

        //Initialize scene
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setTitle("Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
