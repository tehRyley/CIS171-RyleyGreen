package pkgfinal.project.blackjack;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * Project: Final Project BlackJack 
 * Description: A game of BlackJack versus a computer. 
 * Date: 5/12/2023 
 * Author: Ryley Ireland Green
 *
 */
public class FinalProjectBlackJack extends Application {

    //Store card files
    static File folder = new File("src/cards");
    static File[] cards = folder.listFiles();
    static List currentCards = Arrays.asList(cards);
    static int chosen = 0;
    //User score
    static int playerTotal = 0;
    static int computerTotal = 0;
    static Label playerTotalWins = new Label(String.valueOf(playerTotal));
    static Label computerTotalWins = new Label(String.valueOf(computerTotal));
    static Label playerWinsTitle = new Label("Player Wins:");
    static Label computerWinsTitle = new Label("Computer Wins:");
    static int userValue;
    static Label playerScore = new Label();
    static Label computerScore = new Label();
    static String player = "player";
    static String computer = "computer";
    //Winner announcement
    static Label winner = new Label();
    //HBox for users cards
    static HBox bottomBox = new HBox();
    static HBox valueChoice = new HBox();
    //HBox for computer cards
    static HBox topBox = new HBox();
    //buttons for hit and stand
    static Button hit = new Button("Hit");
    static Button stand = new Button("Stand");
    //button for shuffeling
    static Button shuffle = new Button("Shuffle and play again");
    //fonts
    static Font font = new Font(75);
    static Font fontTwo = new Font(50);

    @Override
    public void start(Stage primaryStage) {
        //Deal initial two cards
        Collections.shuffle(currentCards);
        pullCard(bottomBox, player);
        pullCard(bottomBox, player);
        //hit, stand, and shuffle events
        hit.setOnAction(e -> {
            pullCard(bottomBox, player);
        });
        stand.setOnAction(e -> {
            computerTurn();
        });
        if (userValue >= 16) {
            stand.setDisable(false);
        } else {
            stand.setDisable(true);
        }
        shuffle.setOnAction(e -> {
            shuffle();
        });

        //Setting some winner announcement values
        winner.setFont(font);
        winner.setTranslateY(-50);
        //Adjust score layout
        playerWinsTitle.setFont(fontTwo);
        computerWinsTitle.setFont(fontTwo);
        playerTotalWins.setFont(fontTwo);
        computerTotalWins.setFont(fontTwo);
        VBox playerWins = new VBox();
        playerWins.setAlignment(Pos.CENTER);
        playerWins.getChildren().addAll(playerWinsTitle, playerTotalWins);
        VBox computerWins = new VBox();
        computerWins.setAlignment(Pos.CENTER);
        computerWins.getChildren().addAll(computerWinsTitle, computerTotalWins);
        HBox totalWins = new HBox();
        totalWins.getChildren().addAll(playerWins, computerWins);
        VBox topWins = new VBox();
        topWins.setAlignment(Pos.CENTER);
        topWins.getChildren().add(totalWins);
        computerWins.setTranslateX(875);
        //HBox for hit and stand buttons
        HBox choiceBox = new HBox(25);
        choiceBox.setAlignment(Pos.BOTTOM_CENTER);
        choiceBox.getChildren().addAll(hit, stand);
        //Alignment for some HBoxes
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        valueChoice.setAlignment(Pos.BOTTOM_CENTER);
        topBox.setAlignment(Pos.TOP_CENTER);
        topBox.setTranslateY(-80);
        computerScore.setTranslateY(-50);
        //VBox to display everything
        VBox vbox = new VBox(25);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(topBox, computerScore, winner, shuffle, valueChoice, playerScore, choiceBox, bottomBox);
        StackPane root = new StackPane();
        root.getChildren().addAll(topWins, vbox);
        root.setStyle("-fx-background-color: green;");
        //Create and show scene
        Scene scene = new Scene(root, 1500, 1000);
        scene.setFill(Color.GREEN);
        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Pulls random card and stores chosen cards in another array
    public static void pullCard(HBox box, String user) {
        shuffle.setVisible(false);
        String yourCard = currentCards.get(chosen).toString();
        chosen += 1;
        Image dir = new Image(yourCard.substring(yourCard.indexOf("cards")));
        ImageView card = new ImageView(dir);
        card.setFitWidth(200);
        card.setPreserveRatio(true);
        scoreCard(yourCard.substring(yourCard.indexOf("cards")), user);
        box.getChildren().add(card);  
    }

    //Determines value of card
    public static void scoreCard(String cardNum, String user) {
        //Grabs numbers from file name
        String num = cardNum.replaceAll("[^0-9]", "");
        //If blank its a face card
        if (num.isBlank()) {
            userValue += 10;
            //If num == 1 then it's an Ace and needs to give the choice of 1 or 11 as a value
        } else if (Integer.parseInt(num) == 1) {
            if (user.equals(player)) {
                Button one = new Button("One");
                Button eleven = new Button("Eleven");
                one.setOnAction(e -> {
                    int ace = 1;
                    flipButtons(ace, one, eleven);
                });
                eleven.setOnAction(e -> {
                    int ace = 11;
                    flipButtons(ace, one, eleven);
                });
                valueChoice.getChildren().addAll(one, eleven);
                hit.setDisable(true);
                stand.setDisable(true);
            } else {
                if (userValue + 11 <= 21) {
                    userValue += 11;
                } else {
                    userValue += 1;
                }
            }
        } else {
            userValue += Integer.parseInt(num);
        }
        if ("player".equals(user)) {
            playerScore.setText(String.valueOf(userValue));
            if (userValue >= 16) {
                stand.setDisable(false);
            }
            bustCheck();
        } else {
            computerScore.setText(String.valueOf(userValue));
            System.out.println(userValue);
            whoWon();
        }
    }

    //Sets ace value and reverts button functionality
    public static void flipButtons(int ace, Button one, Button eleven) {
        userValue += ace;
        playerScore.setText(String.valueOf(userValue));
        valueChoice.getChildren().removeAll(one, eleven);
        hit.setDisable(false);
        if (userValue >= 16) {
            stand.setDisable(false);
        } else {
            stand.setDisable(true);
        }
        bustCheck();
    }

    //Checks for player win
    public static void bustCheck() {
        if (Integer.parseInt(playerScore.getText()) > 21) {
            winner.setText("Computer Wins!");
            shuffle.setVisible(true);
            computerTotal += 1;
            computerTotalWins.setText(String.valueOf(computerTotal));
            hit.setDisable(true);
            stand.setDisable(true);
        }
    }

    //Computer Starts turn
    public static void computerTurn() {
        hit.setDisable(true);
        stand.setDisable(true);
        userValue = 0;
        pullCard(topBox, computer);
    }

    //Checks a few win conditions
    public static void whoWon() {
        if (userValue == Integer.parseInt(playerScore.getText()) && userValue >= 17) {
            winner.setText("Tie!");
        } else if (userValue < Integer.parseInt(playerScore.getText())) {
            pullCard(topBox, computer);
        } else if (userValue > 21) {
            winner.setText("You Win!");
            playerTotal += 1;
            playerTotalWins.setText(String.valueOf(playerTotal));
        } else if (userValue < 17) {
            pullCard(topBox, computer);
        } else {
            winner.setText("Computer Wins!");
            computerTotal += 1;
            computerTotalWins.setText(String.valueOf(computerTotal));
        }
        shuffle.setVisible(true);
    }

    //Resets the deck for another game
    public static void shuffle() {
        currentCards = Arrays.asList(cards);
        Collections.shuffle(currentCards);
        userValue = 0;
        chosen = 0;
        hit.setDisable(false);
        stand.setDisable(true);
        playerScore.setText("");
        computerScore.setText("");
        bottomBox.getChildren().clear();
        topBox.getChildren().clear();
        winner.setText("");
        pullCard(bottomBox, player);
        pullCard(bottomBox, player);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
