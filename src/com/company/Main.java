package com.company;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    private Stage window;
    private Scene titleScene, createCharacterScene, gameScene, fightScene, cityScene;

    private int[] stats = new int[10];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Acirhia");


        //Elements
        Label startSceneLabel = new Label("Welcome To Acirhia");
        Button startButton = new Button("Start Game");

        startButton.setOnAction(e -> {
            window.setScene(createCharacterScene);
        });

        //--

        Label createCharacterLabel = new Label("Character Creation");
        TextField characterName = new TextField("Character Name: ");
        Button createCharacterButton = new Button("Create Character");
        RadioButton knightRadio = new RadioButton("Knight");
        RadioButton wizardRadio = new RadioButton("Wizard");
        RadioButton archerRadio = new RadioButton("Archer");

        createCharacterButton.setOnAction(e -> {
            PlayerStats player = new PlayerStats(characterName.getText(), stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], 0, 1);
            System.out.println("Character Name: " + player.getName());
            System.out.println("Character Health: " + player.getHealth());
            System.out.println("Character Power: " + player.getPower());
            System.out.println("Character Stamina: " + player.getStamina());
            System.out.println("Character Agility: " + player.getAgility());
            System.out.println("Character Intellect: " + player.getIntellect());
            window.setScene(gameScene);
        });

        knightRadio.setOnAction(e -> {
            stats[0] = 100;  //Base Health
            stats[1] = 100;  //Health
            stats[2] = 10;  //Power
            stats[3] = 6;  //Stamina
            stats[4] = 5;  //Agility
            stats[5] = 4;  //Intellect
        });

        wizardRadio.setOnAction(e -> {
            stats[0] = 100;  //Base Health
            stats[1] = 100;  //Health
            stats[2] = 6;  //Power
            stats[3] = 5;  //Stamina
            stats[4] = 5;  //Agility
            stats[5] = 10;  //Intellect
        });

        archerRadio.setOnAction(e -> {
            stats[0] = 100;  //Base Health
            stats[1] = 100;  //Health
            stats[2] = 7;  //Power
            stats[3] = 8;  //Stamina
            stats[4] = 10;  //Agility
            stats[5] = 5;  //Intellect
        });

        //--

        Button fightButton = new Button("Fight");
        Button cityButton = new Button("Go to Town");

        fightButton.setOnAction(e -> {
            window.setScene(fightScene);
        });

        cityButton.setOnAction(e -> {
            window.setScene(cityScene);
        });

        //Title Scene
        StackPane titleLayout = new StackPane();
        titleLayout.getChildren().addAll(startSceneLabel, startButton);
        titleScene = new Scene(titleLayout, 600, 480);
        window.setScene(titleScene);


        //Create Character
        VBox createCharacterLayout = new VBox(10);
        createCharacterLayout.getChildren().addAll(createCharacterLabel, characterName, knightRadio, wizardRadio, archerRadio, createCharacterButton);
        createCharacterScene = new Scene(createCharacterLayout, 600, 480);

        //Game
        VBox gameLayout = new VBox(20);
        gameLayout.getChildren().addAll(fightButton, cityButton);
        gameScene = new Scene(gameLayout, 600, 480);

        //Fight
        VBox fightLayout = new VBox(20);
        fightLayout.getChildren();
        fightScene = new Scene(fightLayout, 600, 480);

        //City
        VBox cityLayout = new VBox(20);
        cityLayout.getChildren();
        cityScene = new Scene(cityLayout, 600, 480);

        window.show();
        StyleManager.getInstance().addUserAgentStylesheet("com/company/style.css");

    }
}
