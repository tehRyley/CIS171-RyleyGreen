package pkg24.pkg7animationlinkedlist;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Ryley Ireland Green
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Initialize list
        LinkedList<Integer> list = new LinkedList<>();

        //Create Buttons
        Button btnSearch = new Button();
        Button btnInsert = new Button();
        Button btnDelete = new Button();
        btnSearch.setText("Search");
        btnInsert.setText("Insert");
        btnDelete.setText("Delete");

        //Create value text field
        TextField valueField = new TextField();
        valueField.setPrefWidth(50);
        valueField.setPromptText("Value");
        TextField indexField = new TextField();
        indexField.setPrefWidth(50);
        indexField.setPromptText("Index");

        //Display list
        Label listText = new Label();
        Label containsText = new Label();
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 15);
        containsText.setFont(font);

        //Checks for key pressed in fields and warns if not int
        valueField.setOnKeyTyped((KeyEvent e) -> {
            if (e.getCharacter().matches("[a-zA-Z]+")) {
                containsText.setText("Use an Int for a value!");
                valueField.setText("");
            } else {
                containsText.setText("");
            }
        });
        indexField.setOnKeyTyped((KeyEvent e) -> {
            if (e.getCharacter().matches("[a-zA-Z]+")) {
                containsText.setText("Use an Int for the index!");
                indexField.setText("");
            } else {
                containsText.setText("");
            }
        });

        //Set actions for buttons
        btnSearch.setOnAction((ActionEvent event) -> {
            if ("".equals(valueField.getText())) {
                containsText.setText("Specify a value for search!");
            } else {
                if (list.contains(Integer.valueOf(valueField.getText()))) {
                    containsText.setText("List contains " + Integer.valueOf(valueField.getText()));
                } else {
                    containsText.setText("List does not contain " + Integer.valueOf(valueField.getText()));
                }
            }
        });
        btnInsert.setOnAction((ActionEvent event) -> {
            if ("".equals(valueField.getText()) && "".equals(indexField.getText())) {
                containsText.setText("Specify a value for insertion!");
            } else {
                if ("".equals(indexField.getText())) {
                   list.add(Integer.valueOf(valueField.getText()));
                } else if (Integer.parseInt(indexField.getText()) > list.size() - 1) {
                    containsText.setText("Specified index is out of range!");
                    indexField.setText("");
                } else {
                   list.set(Integer.parseInt(indexField.getText()), Integer.valueOf(valueField.getText()));
                }
            }
            listText.setText(list.toString());
        });
        btnDelete.setOnAction((ActionEvent event) -> {
            if ("".equals(valueField.getText())) {
                containsText.setText("Specify a value for deletion!");
            } else {
                list.remove(Integer.valueOf(valueField.getText()));
                listText.setText(list.toString());
            }

        });

        //Create and adjust layout
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(btnSearch, btnInsert, btnDelete, valueField, indexField);
        hbox.setPadding(new Insets(15, 0, 0, 0));
        vbox.getChildren().addAll(listText, containsText, hbox);

        //Set scene
        Scene scene = new Scene(vbox, 300, 100);
        primaryStage.setTitle("List Manager");
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
