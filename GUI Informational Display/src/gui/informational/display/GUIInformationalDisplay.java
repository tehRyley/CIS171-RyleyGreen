package gui.informational.display;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Ryley
 */
public class GUIInformationalDisplay extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new VBox(5);
        pane.setPadding(new Insets(5,5,5,5));        
        
        Text head = new Text("Incoming Ice Storm"); 
        head.setFont(Font.font("arial", FontWeight.BOLD, 50));
        pane.getChildren().add(head);
        Image image = new Image("https://www.gannett-cdn.com/presto/2022/01/31/USAT/cdf31529-02e1-4284-907a-079b70ae69d8-08f284f9-f00d-4e1c-8b17-ff8ff7c1551b_thumbnail.png?width=1280&height=720&fit=crop&format=pjpg&auto=webp");
        pane.getChildren().add(new ImageView(image));
       
        Button btn = new Button();
        btn.setText("Send");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Not yet implemented");
            }
        });
        
        TextField moreText = new TextField("Write your questions about weather preperation here.");
        pane.getChildren().add(moreText);
        pane.getChildren().add(btn);
        btn.setMinSize(80, 40);
        btn.setFont(Font.font("arial", FontWeight.BOLD, 25));
        Scene scene = new Scene(pane);
        btn.setContentDisplay(ContentDisplay.BOTTOM);
        primaryStage.setTitle("Send");
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
