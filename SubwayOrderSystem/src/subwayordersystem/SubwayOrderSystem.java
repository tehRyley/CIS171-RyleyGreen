package subwayordersystem;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * Project: Subway Order System 
 * Description: GUI for building your own Subway sandwich. 
 * Date: 5/12/2023 
 * Author: Ryley Ireland Green
 *
 */
public class SubwayOrderSystem extends Application {

    static int selectedAmount;
    static int selection = 1;
    static Label subVeggies = new Label("Max 3");
    static CheckBox lettuce = new CheckBox("Lettuce");
    static CheckBox onions = new CheckBox("Onions");
    static CheckBox pickles = new CheckBox("Pickles");
    static CheckBox tomatoes = new CheckBox("Tomatoes");
    Button btn = new Button();
    static List vegNames = new ArrayList();

    @Override
    public void start(Stage primaryStage) {
        //Font sizes
        Font font = new Font(30);
        Font fontTwo = new Font(15);

        //Subway logo
        Image image = new Image("logo/subway.png");
        ImageView logo = new ImageView(image);
        logo.setFitWidth(500);
        logo.setPreserveRatio(true);

        //Sandwich options
        //Size labels
        Label sixLabel = new Label("Six\"");
        Label footLabel = new Label("Footlong");
        sixLabel.setFont(font);
        footLabel.setFont(font);
        sixLabel.setTranslateX(-30);
        //Six inch image
        Image sixImage = new Image("size/six.png");
        ImageView six = new ImageView(sixImage);
        six.setFitWidth(250);
        six.setPreserveRatio(true);
        //Footlong image
        Image footImage = new Image("size/foot.png");
        ImageView foot = new ImageView(footImage);
        foot.setFitWidth(350);
        foot.setPreserveRatio(true);

        //Bread image
        Image breadImage = new Image("bread/bread.png");
        ImageView bread = new ImageView(breadImage);
        bread.setFitWidth(500);
        bread.setPreserveRatio(true);
        bread.setTranslateY(-50);

        //Bread radio buttons
        ToggleGroup breadGroup = new ToggleGroup();
        RadioButton wheat = new RadioButton("Wheat");
        wheat.setToggleGroup(breadGroup);
        wheat.setFont(fontTwo);
        wheat.setSelected(true);
        wheat.setUserData("Wheat");
        RadioButton honey = new RadioButton("Honey Oat");
        honey.setToggleGroup(breadGroup);
        honey.setFont(fontTwo);
        honey.setUserData("Honey Oat");
        RadioButton italian = new RadioButton("Italian");
        italian.setToggleGroup(breadGroup);
        italian.setFont(fontTwo);
        italian.setUserData("Italian");
        RadioButton herb = new RadioButton("Italian Herb & Cheese");
        herb.setToggleGroup(breadGroup);
        herb.setFont(fontTwo);
        herb.setUserData("Italian Herb & Cheese");
        RadioButton flat = new RadioButton("Flatbread");
        flat.setToggleGroup(breadGroup);
        flat.setFont(fontTwo);
        flat.setUserData("Flatbread");

        //Toasted?
        Label toasted = new Label("Toasted?");
        toasted.setFont(fontTwo);
        toasted.setTranslateY(-70);
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Yes", "No");
        comboBox.getSelectionModel().selectFirst();
        comboBox.setTranslateY(-70);

        //Meat title
        Label meat = new Label("Meat:");
        meat.setFont(font);
        meat.setTranslateY(-35);

        //Meat Images
        Image chickenImage = new Image("meat/chicken.png");
        ImageView chickenV = new ImageView(chickenImage);
        Image hamImage = new Image("meat/ham.png");
        ImageView hamV = new ImageView(hamImage);
        Image beefImage = new Image("meat/roastbeef.png");
        ImageView beefV = new ImageView(beefImage);
        Image turkeyImage = new Image("meat/turkey.png");
        ImageView turkeyV = new ImageView(turkeyImage);
        chickenV.setFitWidth(150);
        chickenV.setPreserveRatio(true);
        hamV.setFitWidth(150);
        hamV.setPreserveRatio(true);
        hamV.setTranslateY(-15);
        beefV.setFitWidth(150);
        beefV.setPreserveRatio(true);
        turkeyV.setFitWidth(150);
        turkeyV.setPreserveRatio(true);
        turkeyV.setTranslateY(20);

        //Meat radio buttons
        ToggleGroup meatGroup = new ToggleGroup();
        RadioButton chicken = new RadioButton("Chicken");
        chicken.setToggleGroup(meatGroup);
        chicken.setFont(fontTwo);
        chicken.setSelected(true);
        chicken.setUserData("Chicken");
        RadioButton ham = new RadioButton("Ham");
        ham.setToggleGroup(meatGroup);
        ham.setFont(fontTwo);
        ham.setUserData("Ham");
        RadioButton beef = new RadioButton("Roast Beef");
        beef.setToggleGroup(meatGroup);
        beef.setFont(fontTwo);
        beef.setUserData("Roast Beef");
        RadioButton turkey = new RadioButton("Turkey");
        turkey.setToggleGroup(meatGroup);
        turkey.setFont(fontTwo);
        turkey.setUserData("Turkey");

        //Cheese title
        Label cheese = new Label("Cheese:");
        cheese.setFont(font);
        cheese.setTranslateY(-40);

        //Cheese Images
        Image americanImage = new Image("cheese/American.png");
        ImageView americanV = new ImageView(americanImage);
        Image cheddarImage = new Image("cheese/cheddar.png");
        ImageView cheddarV = new ImageView(cheddarImage);
        Image pepperjackImage = new Image("cheese/pepperjack.png");
        ImageView pepperjackV = new ImageView(pepperjackImage);
        Image provoloneImage = new Image("cheese/provolone.png");
        ImageView provoloneV = new ImageView(provoloneImage);
        americanV.setFitWidth(150);
        americanV.setPreserveRatio(true);
        cheddarV.setFitWidth(150);
        cheddarV.setPreserveRatio(true);
        pepperjackV.setFitWidth(150);
        pepperjackV.setPreserveRatio(true);
        pepperjackV.setTranslateY(-30);
        provoloneV.setFitWidth(150);
        provoloneV.setPreserveRatio(true);

        //Cheese radio buttons
        ToggleGroup cheeseGroup = new ToggleGroup();
        RadioButton american = new RadioButton("American");
        american.setToggleGroup(cheeseGroup);
        american.setFont(fontTwo);
        american.setUserData("American");
        RadioButton cheddar = new RadioButton("Cheddar");
        cheddar.setToggleGroup(cheeseGroup);
        cheddar.setFont(fontTwo);
        cheddar.setUserData("Cheddar");
        RadioButton pepperjack = new RadioButton("Pepperjack");
        pepperjack.setToggleGroup(cheeseGroup);
        pepperjack.setFont(fontTwo);
        pepperjack.setSelected(true);
        pepperjack.setUserData("Pepperjack");
        RadioButton provolone = new RadioButton("Provolone");
        provolone.setToggleGroup(cheeseGroup);
        provolone.setFont(fontTwo);
        provolone.setUserData("Provolone");

        //Veggies title
        Label veggies = new Label("Veggies:");
        veggies.setFont(font);
        veggies.setTranslateY(-30);
        //Veggies subtitle
        subVeggies.setFont(Font.font("Regular", FontPosture.ITALIC, 15));
        subVeggies.setTranslateY(-35);

        //Veggie Images
        Image lettuceImage = new Image("veggies/lettuce.png");
        ImageView lettuceV = new ImageView(lettuceImage);
        Image onionsImage = new Image("veggies/onions.png");
        ImageView onionsV = new ImageView(onionsImage);
        Image picklesImage = new Image("veggies/pickles.png");
        ImageView picklesV = new ImageView(picklesImage);
        Image tomatoesImage = new Image("veggies/tomatoes.png");
        ImageView tomatoesV = new ImageView(tomatoesImage);
        lettuceV.setFitWidth(150);
        lettuceV.setPreserveRatio(true);
        onionsV.setFitWidth(150);
        onionsV.setPreserveRatio(true);
        picklesV.setFitWidth(150);
        picklesV.setPreserveRatio(true);
        tomatoesV.setFitWidth(150);
        tomatoesV.setPreserveRatio(true);
        tomatoesV.setTranslateY(30);

        //Veggie check boxes
        tomatoes.setFont(fontTwo);
        pickles.setFont(fontTwo);
        onions.setFont(fontTwo);
        lettuce.setFont(fontTwo);

        //Sauce title
        Label sauce = new Label("Sauce:");
        sauce.setFont(font);
        sauce.setTranslateY(-50);

        //Sauce Image
        Image sauceImage = new Image("sauce/sauce.png");
        ImageView sauceV = new ImageView(sauceImage);
        sauceV.setFitWidth(175);
        sauceV.setPreserveRatio(true);
        sauceV.setTranslateY(-50);

        //Sauce radio buttons
        ToggleGroup sauceGroup = new ToggleGroup();
        RadioButton mustard = new RadioButton("Dijon Mustard");
        mustard.setToggleGroup(sauceGroup);
        mustard.setFont(fontTwo);
        mustard.setSelected(true);
        mustard.setUserData("Dijon Mustard");
        RadioButton bbq = new RadioButton("Sweet and Tangy BBQ");
        bbq.setToggleGroup(sauceGroup);
        bbq.setFont(fontTwo);
        bbq.setUserData("Sweet and Tangy BBQ");
        RadioButton mayo = new RadioButton("Mayonnaise");
        mayo.setToggleGroup(sauceGroup);
        mayo.setFont(fontTwo);
        mayo.setUserData("Mayonnaise");
        RadioButton chipotle = new RadioButton("Chipotle");
        chipotle.setToggleGroup(sauceGroup);
        chipotle.setFont(fontTwo);
        chipotle.setUserData("Chipotle");

        //Salt and pepper
        btn.setMinSize(100, 50);
        Label saltnpepper = new Label("Salt or Pepper?");
        saltnpepper.setFont(fontTwo);
        saltnpepper.setTranslateY(-30);
        ComboBox saltnpepperBox = new ComboBox();
        saltnpepperBox.getItems().addAll("Both", "Salt", "Pepper", "No");
        saltnpepperBox.getSelectionModel().selectFirst();
        saltnpepperBox.setTranslateY(-25);

        //Order button to display summary
        btn.setText("Place Order");
        btn.setTranslateY(-10);
        //Veggie Counter
        lettuce.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                selectedAmount += 1;
            } else {
                selectedAmount -= 1;
            }
        });
        onions.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                selectedAmount += 1;
            } else {
                selectedAmount -= 1;
            }
        });
        pickles.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                selectedAmount += 1;
            } else {
                selectedAmount -= 1;
            }
        });
        tomatoes.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                selectedAmount += 1;
            } else {
                selectedAmount -= 1;
            }
        });
        lettuce.setOnMouseClicked(e -> {
            veggieSelection();
        });
        onions.setOnMouseClicked(e -> {
            veggieSelection();
        });
        pickles.setOnMouseClicked(e -> {
            veggieSelection();
        });
        tomatoes.setOnMouseClicked(e -> {
            veggieSelection();
        });
        btn.setOnAction(e -> {
            //Size
            Label sizeTitle = new Label("Size: ");
            sizeTitle.setFont(font);
            Label size = new Label();
            size.setTranslateY(-10);
            ImageView imageSel = new ImageView();
            imageSel.setTranslateY(-15);
            size.setFont(fontTwo);
            if (selection == 1) {
                size.setText("Footlong");
                imageSel.setImage(footImage);
                imageSel.setFitWidth(150);
                imageSel.setFitHeight(100);
            } else {
                size.setText("Six\"");
                imageSel.setImage(sixImage);
                imageSel.setFitWidth(100);
                imageSel.setFitHeight(75);
            }
            //Bread
            Label breadTitle = new Label("Bread: ");
            breadTitle.setTranslateY(-15);
            breadTitle.setFont(font);
            Label breadType = new Label(breadGroup.getSelectedToggle().getUserData().toString());
            breadType.setTranslateY(-25);
            breadType.setFont(Font.font("Regular", 20));
            Label toastSel = new Label();
            toastSel.setTranslateY(-30);
            toastSel.setFont(Font.font("Regular", FontPosture.ITALIC, 15));
            if ("Yes".equals(comboBox.getValue().toString())) {
                toastSel.setText("Toasted");
            } else {
                toastSel.setText("Not Toasted");
            }
            //Meat
            Label meatTitle = new Label("Meat: ");
            meatTitle.setTranslateY(-25);
            meatTitle.setFont(font);
            Label meatType = new Label(meatGroup.getSelectedToggle().getUserData().toString());
            meatType.setTranslateY(-35);
            meatType.setFont(Font.font("Regular", 20));
            ImageView meatV = new ImageView();
            meatV.setFitWidth(100);
            meatV.setPreserveRatio(true);
            meatV.setTranslateY(-55);
            switch (meatType.getText()) {
                case "Chicken" ->
                    meatV.setImage(chickenImage);
                case "Ham" ->
                    meatV.setImage(hamImage);
                case "Roast Beef" -> {
                    meatV.setImage(beefImage);
                    meatV.setTranslateY(-55);
                }
                case "Turkey" -> {
                    meatV.setImage(turkeyImage);
                    meatV.setTranslateY(-40);
                }
            }
            //Cheese
            Label CheeseTitle = new Label("Cheese: ");
            CheeseTitle.setTranslateY(-15);
            CheeseTitle.setFont(font);
            CheeseTitle.setTranslateY(-50);
            Label cheeseType = new Label(cheeseGroup.getSelectedToggle().getUserData().toString());
            cheeseType.setTranslateY(-60);
            cheeseType.setFont(Font.font("Regular", 20));
            ImageView cheeseV = new ImageView();
            cheeseV.setFitWidth(100);
            cheeseV.setPreserveRatio(true);
            cheeseV.setTranslateY(-75);
            switch (cheeseType.getText()) {
                case "American" -> {
                    cheeseV.setImage(americanImage);
                    cheeseV.setTranslateY(-55);
                }
                case "Cheddar" ->
                    cheeseV.setImage(cheddarImage);
                case "Pepperjack" ->
                    cheeseV.setImage(pepperjackImage);
                case "Provolone" -> {
                    cheeseV.setImage(provoloneImage);
                    cheeseV.setTranslateY(-65);
                }
            }
            //Veggies
            Label veggieTitle = new Label("Veggies: ");
            veggieTitle.setFont(font);
            veggieTitle.setTranslateY(-75);
            veggieCheck(lettuce);
            veggieCheck(onions);
            veggieCheck(pickles);
            veggieCheck(tomatoes);
            HBox hboxTwo = new HBox(70);
            hboxTwo.setAlignment(Pos.TOP_CENTER);
            hboxTwo.setTranslateY(-75);
            HBox hboxThree = new HBox(10);
            hboxThree.setAlignment(Pos.TOP_CENTER);
            hboxThree.setTranslateY(-75);
            for (int i = 0; i < vegNames.size(); i++) {
                Image vegI = new Image("veggies/" + vegNames.get(i).toString() + ".png");
                ImageView vegV = new ImageView(vegI);
                if ("Tomatoes".equals(vegNames.get(i).toString())) {
                    vegV.setTranslateY(10);
                } else {
                    vegV.setTranslateY(-10);
                }
                vegV.setFitWidth(100);
                vegV.setPreserveRatio(true);
                Label veggieList = new Label(vegNames.get(i).toString());
                hboxTwo.getChildren().add(veggieList);
                hboxThree.getChildren().add(vegV);
            }
            //Sauce
            Label sauceTitle = new Label("Sauce: ");
            sauceTitle.setTranslateY(-95);
            sauceTitle.setFont(font);
            Label SauceType = new Label(sauceGroup.getSelectedToggle().getUserData().toString());
            SauceType.setTranslateY(-105);
            SauceType.setFont(Font.font("Regular", 20));
            sauceV.setFitWidth(75);
            sauceV.setPreserveRatio(true);
            sauceV.setTranslateY(-105);
            //Salt and Pepper
            Label snpTitle = new Label("Salt or Pepper: ");
            snpTitle.setTranslateY(-105);
            snpTitle.setFont(font);
            Label snpSel = new Label();
            snpSel.setTranslateY(-115);
            snpSel.setFont(Font.font("Regular", FontPosture.ITALIC, 15));
            snpSel.setText(saltnpepperBox.getValue().toString());
            if (vegNames.isEmpty()) {
                veggieTitle.setText("");
            }
            //Layout
            Button btnTwo = new Button();
            btnTwo.setMinSize(50, 25);
            btnTwo.setText("Back");
            btnTwo.setTranslateY(-105);
            btnTwo.setOnAction((ActionEvent event) -> {
                selectedAmount = vegNames.size();
                vegNames.clear();
                start(primaryStage);
            });
            VBox vboxTwo = new VBox();
            vboxTwo.setAlignment(Pos.TOP_CENTER);
            vboxTwo.getChildren().addAll(logo, sizeTitle, size, imageSel, breadTitle, breadType, toastSel, meatTitle, meatType, meatV, CheeseTitle, cheeseType, cheeseV, veggieTitle, hboxTwo, hboxThree, sauceTitle, SauceType, sauceV, snpTitle, snpSel, btnTwo);
            Scene sceneTwo = new Scene(vboxTwo, 765, 1000);
            sceneTwo.getStylesheets().add("stylesheet.css");
            primaryStage.setTitle("Subway Summary");
            primaryStage.setScene(sceneTwo);
        });

        //Size selection
        six.setOnMouseClicked(e -> {
            selection = 0;
            sizeSelection(sixLabel, footLabel, six, foot);
        });
        foot.setOnMouseClicked(e -> {
            selection = 1;
            sizeSelection(footLabel, sixLabel, foot, six);
        });
        //Initial selection
        sizeSelection(footLabel, sixLabel, foot, six);

        //Layout (HBoxs within VBox)
        ScrollPane scroll = new ScrollPane();
        HBox sizeTitle = new HBox(200);
        sizeTitle.setAlignment(Pos.BOTTOM_CENTER);
        sizeTitle.getChildren().addAll(sixLabel, footLabel);
        sizeTitle.setTranslateY(5);
        HBox sizeBox = new HBox();
        sizeBox.setAlignment(Pos.TOP_CENTER);
        sizeBox.getChildren().addAll(six, foot);
        HBox breadBox = new HBox(25);
        breadBox.setAlignment(Pos.TOP_CENTER);
        breadBox.getChildren().addAll(wheat, honey, italian, herb, flat);
        breadBox.setTranslateY(-70);
        HBox meatImgs = new HBox(15);
        meatImgs.setAlignment(Pos.TOP_CENTER);
        meatImgs.getChildren().addAll(chickenV, hamV, beefV, turkeyV);
        meatImgs.setTranslateY(-55);
        HBox meatBox = new HBox(90);
        meatBox.getChildren().addAll(chicken, ham, beef, turkey);
        meatBox.setAlignment(Pos.TOP_CENTER);
        meatBox.setTranslateY(-90);
        HBox cheeseImgs = new HBox(15);
        cheeseImgs.getChildren().addAll(pepperjackV, americanV, cheddarV, provoloneV);
        cheeseImgs.setAlignment(Pos.TOP_CENTER);
        cheeseImgs.setTranslateY(-50);
        HBox cheeseBox = new HBox(85);
        cheeseBox.getChildren().addAll(pepperjack, american, cheddar, provolone);
        cheeseBox.setAlignment(Pos.TOP_CENTER);
        cheeseBox.setTranslateY(-90);
        HBox veggieImgs = new HBox();
        veggieImgs.getChildren().addAll(lettuceV, onionsV, picklesV, tomatoesV);
        veggieImgs.setAlignment(Pos.TOP_CENTER);
        veggieImgs.setTranslateY(-80);
        HBox veggieBox = new HBox(70);
        veggieBox.getChildren().addAll(lettuce, onions, pickles, tomatoes);
        veggieBox.setAlignment(Pos.TOP_CENTER);
        veggieBox.setTranslateY(-100);
        HBox sauceBox = new HBox(25);
        sauceBox.getChildren().addAll(mustard, bbq, mayo, chipotle);
        sauceBox.setAlignment(Pos.TOP_CENTER);
        sauceBox.setTranslateY(-45);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(logo, sizeTitle, sizeBox, bread, breadBox, toasted, comboBox, meat, meatImgs, meatBox, cheese,
                cheeseImgs, cheeseBox, veggies, subVeggies, veggieImgs, veggieBox, sauce, sauceV, sauceBox, saltnpepper, saltnpepperBox, btn);
        scroll.setContent(vbox);
        Scene scene = new Scene(scroll, 665, 1000);
        scene.getStylesheets().add("stylesheet.css");
        primaryStage.setTitle("Subway Order");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Sub size selection
    public static void sizeSelection(Label selected, Label notSelected, ImageView selectedImg, ImageView notSelectedImg) {
        selected.setFont(Font.font("Regular", FontWeight.BOLD, 35));
        notSelected.setFont(Font.font("Regular", FontWeight.NORMAL, 30));
        selected.setTextFill(Color.GREEN);
        notSelected.setTextFill(Color.BLACK);
        if (selection == 1) {
            selectedImg.setFitWidth(400);
            notSelectedImg.setFitWidth(250);
        } else {
            selectedImg.setFitWidth(300);
            notSelectedImg.setFitWidth(350);
        }
    }

    //Veggie selection
    public static void veggieSelection() {
        if (lettuce.isDisabled() || onions.isDisabled() || pickles.isDisabled() || tomatoes.isDisabled()) {
            lettuce.setDisable(false);
            onions.setDisable(false);
            pickles.setDisable(false);
            tomatoes.setDisable(false);
        } else if (selectedAmount >= 3) {
            if (lettuce.isSelected() == false) {
                lettuce.setDisable(true);
            }
            if (onions.isSelected() == false) {
                onions.setDisable(true);
            }
            if (pickles.isSelected() == false) {
                pickles.setDisable(true);
            }
            if (tomatoes.isSelected() == false) {
                tomatoes.setDisable(true);
            }
        }
    }

    //Veggie selection check
    public static void veggieCheck(CheckBox veggie) {
        if (veggie.isSelected()) {
            vegNames.add(veggie.getText());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
