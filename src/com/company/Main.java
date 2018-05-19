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

    private PlayerStats player;
    private EnemyStats enemy;
    private int[] stats = new int[10];
    private String[] enemyNames = {
            "Skeleton",
            "Zombie",
            "Void Elf",
            "Fire Atronach",
            "Orc"
    };

    //Main Scene Elements
    private StackPane titleLayout = new StackPane();
    private VBox createCharacterLayout = new VBox(10);
    private VBox gameLayout = new VBox(20);
    private VBox fightLayout = new VBox(20);
    private VBox cityLayout = new VBox(20);

    //Elements
    private Label startSceneLabel = new Label("Welcome To Acirhia");
    private Button startButton = new Button("Start Game");
    private Label createCharacterLabel = new Label("Character Creation");
    private TextField characterName = new TextField("Character Name: ");
    private Button createCharacterButton = new Button("Create Character");
    private RadioButton knightRadio = new RadioButton("Knight");
    private RadioButton wizardRadio = new RadioButton("Wizard");
    private RadioButton archerRadio = new RadioButton("Archer");
    private Button fightButton = new Button("Fight");
    private Button cityButton = new Button("Go to Town");
    private Label playerHealth;
    private Label enemyHealth;
    private Button heavyAttackButton = new Button("Heavy Attack");
    private Button lightAttackButton = new Button("Light Attack");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Acirhia");


        //Elements
        startButton.setOnAction(e -> {
            window.setScene(createCharacterScene);
        });

        createCharacterButton.setOnAction(e -> {
            player = new PlayerStats(characterName.getText(), stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], 0, 1);
            System.out.println("Character Created: ");
            System.out.println("Name: " + player.getName());
            System.out.println("Health: " + player.getHealth());
            System.out.println("Power: " + player.getPower());
            System.out.println("Stamina: " + player.getStamina());
            System.out.println("Agility: " + player.getAgility());
            System.out.println("Intellect: " + player.getIntellect());
            playerHealth = new Label("Player Health: " + player.getHealth());
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

        fightButton.setOnAction(e -> {
            window.setScene(fightScene);
            String enemyName = enemyNames[(RNG(enemyNames.length))];


            enemy = new EnemyStats(enemyName, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
            System.out.println("Enemy Encountered: ");
            System.out.println("Name: " + enemy.getName());
            enemyHealth = new Label(enemy.getName() + ": " + enemy.getHealth());
            fightLayout.getChildren().addAll(playerHealth, enemyHealth, lightAttackButton, heavyAttackButton);
        });

        cityButton.setOnAction(e -> {
            window.setScene(cityScene);
        });

        lightAttackButton.setOnAction(e -> {
            calculateDamage(1);
        });

        heavyAttackButton.setOnAction(e -> {
            calculateDamage(2);
        });



        //Title Scene
        titleLayout.getChildren().addAll(startSceneLabel, startButton);
        titleScene = new Scene(titleLayout, 600, 480);
        window.setScene(titleScene);


        //Create Character
        createCharacterLayout.getChildren().addAll(createCharacterLabel, characterName, knightRadio, wizardRadio, archerRadio, createCharacterButton);
        createCharacterScene = new Scene(createCharacterLayout, 600, 480);

        //Game
        gameLayout.getChildren().addAll(fightButton, cityButton);
        gameScene = new Scene(gameLayout, 600, 480);

        //Fight
        fightScene = new Scene(fightLayout, 600, 480);

        //City
        cityLayout.getChildren();
        cityScene = new Scene(cityLayout, 600, 480);

        window.show();
        StyleManager.getInstance().addUserAgentStylesheet("com/company/style.css");

    }

    private static int RNG(int num) {
        int rand = (int) (Math.floor(Math.random() * num));

        return rand;
    }

    private void calculateDamage(int attack) {
        int dmg = 0;
        if(attack == 1) {
            dmg = RNG(player.getPower());
            enemy.setHealth((enemy.getHealth() - dmg));
            System.out.println("Enemy Health is now: " + enemy.getHealth());
        }else if(attack == 2) {
            dmg = RNG((player.getPower() * 2));
            enemy.setHealth((enemy.getHealth() - dmg));
            System.out.println("Enemy Health is now: " + enemy.getHealth());
        }
    }
}
