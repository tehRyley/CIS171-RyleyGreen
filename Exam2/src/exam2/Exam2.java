package exam2;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Ryley Ireland Green
 */
public class Exam2 extends Application {

    private static final DecimalFormat decfor = new DecimalFormat("0.00");  
    
    @Override
    public void start(Stage primaryStage) {
        //Create labels and textfields
        Label labelUS = new Label("US Dollars");
        Label labelCA = new Label("Canadian Dollars");
        TextField textUS = new TextField();
        textUS.setAlignment(Pos.TOP_RIGHT);
        textUS.setPrefWidth(285);
        textUS.setPrefHeight(30);
        TextField textCA = new TextField();
        textCA.setDisable(true);
        textCA.setAlignment(Pos.TOP_RIGHT);
        textCA.setPrefWidth(285);
        textCA.setPrefHeight(30);

        //Create convert button with event
        Button btn = new Button();
        btn.setText("Convert");
        btn.setOnAction((ActionEvent event) -> {
            double cad = Double.parseDouble(textUS.getText()) * 1.3729;
            textCA.setText(String.valueOf(decfor.format(cad)));
        } //At the time of creation 1.3729 converts correctly
        );

        //Place nodes and position into panes
        GridPane root = new GridPane();
        HBox btnBox = new HBox();
        btnBox.setAlignment(Pos.BOTTOM_RIGHT);
        btnBox.getChildren().add(btn);
        btnBox.setPadding(new Insets(3, 5, 5, 0));
        root.add(labelUS, 0, 0);
        root.add(textUS, 1, 0);
        root.add(labelCA, 0, 1);
        root.add(textCA, 1, 1);
        root.add(btnBox, 1, 2);

        //Create scene and set stage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Convert US Dollars to Canadian Dollars");
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
