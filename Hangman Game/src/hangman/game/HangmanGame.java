package hangman.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 *
 * @author Ryley
 */
public class HangmanGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Creating arc for base
        Arc arc = new Arc();
        //Setting the properties of the arc 
        arc.setCenterX(300.0f);
        arc.setCenterY(150.0f);
        arc.setRadiusX(90.0f);
        arc.setRadiusY(50.0f);
        arc.setStartAngle(40.0f);
        arc.setLength(100.0f);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(2.0);
        //Position the arc
        arc.setTranslateX(-225);
        arc.setTranslateY(275);

        //Creating path for the hang
        Path path = new Path();
        path.setStrokeWidth(2.0);
        //Starting point
        MoveTo moveTo = new MoveTo(75, 375);
        //Create movement lines
        LineTo line1 = new LineTo(75, 25);
        LineTo line2 = new LineTo(250, 25);
        LineTo line3 = new LineTo(250, 50);
        //Add movements
        path.getElements().add(moveTo);
        path.getElements().addAll(line1, line2, line3);

        //Creating a circle for the head     
        Circle circle = new Circle();
        circle.setCenterX(250.0f);
        circle.setCenterY(85.0f);
        circle.setRadius(35.0f);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2.0);

        //Create path for body and legs
        Path pathTwo = new Path();
        pathTwo.setStrokeWidth(2.0);
        //Starting point
        MoveTo moveBod = new MoveTo(250, 120);
        //Create movement lines
        LineTo line11 = new LineTo(250, 220);
        LineTo line12 = new LineTo(325, 275);
        LineTo line13 = new LineTo(250, 220);
        LineTo line14 = new LineTo(170, 270);
        //Add movements
        pathTwo.getElements().add(moveBod);
        pathTwo.getElements().addAll(line11, line12, line13, line14);

        //Left arm
        Line leftLine = new Line();
        leftLine.setStrokeWidth(2.0);
        leftLine.setStartX(270.0);
        leftLine.setStartY(115.0);
        leftLine.setEndX(360.0);
        leftLine.setEndY(170.0);

        //Right arm
        Line rightLine = new Line();
        rightLine.setStrokeWidth(2.0);
        rightLine.setStartX(230.0);
        rightLine.setStartY(115.0);
        rightLine.setEndX(150.0);
        rightLine.setEndY(170.0);

        //Create pane and add nodes
        Pane pane = new Pane();
        pane.getChildren().addAll(arc, path, circle, pathTwo, leftLine, rightLine);

        //Create scene
        Scene scene = new Scene(pane, 400, 400);

        primaryStage.setTitle("HangMan");
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
