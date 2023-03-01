package demonstrate.textfield.properties;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Ryley Ireland Green
 */
public class DemonstrateTextFieldProperties extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create two text fields
        TextField tfTextField = new TextField();
        TextField tfPrefColumnSize = new TextField();
        tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
        tfPrefColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        tfTextField.setPrefColumnCount(15);
        tfPrefColumnSize.setPrefColumnCount(5);

        //Place testing text field into top center
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(new Label("Text Field"), tfTextField);

        //Create Radio Buttons
        RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
        RadioButton rbRight = new RadioButton("Right");

        //Create group for radio buttons
        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);

        //Place radio buttons bottom center
        HBox hBox2 = new HBox(5);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(rbLeft, rbCenter, rbRight);

        //Label and add text field to change testing box size
        HBox hBox3 = new HBox(5);
        hBox3.getChildren().addAll(new Label("Column Size"), tfPrefColumnSize);

        //Combine layouts
        HBox hBox4 = new HBox(15);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.getChildren().addAll(hBox2, hBox3);
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(hBox1, hBox4);

        //Set scene
        Scene scene = new Scene(vBox, 350, 60);
        primaryStage.setTitle("Radio Test");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Add functionality to radio buttons and second text field using event handlers
        tfPrefColumnSize.setOnAction(e -> {
            tfTextField.setPrefColumnCount(
                    Integer.parseInt(tfPrefColumnSize.getText())
            );
        });
        rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_LEFT));
        rbCenter.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_CENTER));
        rbRight.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_RIGHT));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
