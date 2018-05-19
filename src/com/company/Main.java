package com.company;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Button.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;

public class Main extends Application{

    private Stage window;
    private Scene titleScene, createCharacterScene, gameScene, fightScene, cityScene, characterStatsScene, victoryScene, defeatScene;

    private PlayerStats player;
    private String playerClass;
    private ItemDataBase[] inventory;
    private Quest[] questLog;

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
    private VBox characterStatsLayout = new VBox(20);
    private VBox fightLayout = new VBox(20);
    private VBox cityLayout = new VBox(20);
    private VBox victoryLayout = new VBox(20);

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
    private Button characterStatsButton = new Button("Character Stats");

    private Label characterStatsName = new Label();
    private Label characterStatsHealth = new Label();
    private Label characterStatsLevel = new Label();
    private Label characterStatsExp = new Label();
    private Label characterStatsPower = new Label();
    private Label characterStatsStamina = new Label();
    private Label characterStatsAgility = new Label();
    private Label characterStatsIntellect = new Label();
    private Label characterStatsGold = new Label();
    private Button backToGameButton = new Button("Go Back");

    private Label playerHealth;
    private Label enemyHealth;
    private Button heavyAttackButton = new Button("Heavy Attack");
    private Button lightAttackButton = new Button("Light Attack");
    private Button victoryButton = new Button("Victory!");
    private Button defeatButton = new Button("Defeat...");

    private Label expReward = new Label();
    private Label goldReward = new Label();
    private Label itemReward = new Label();
    private Label levelUpLabel = new Label("Level Up!");
    private Button continueButton = new Button("Continue");



    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Acirhia");

        //Title Scene
        titleLayout.getChildren().addAll(startSceneLabel, startButton);
        titleScene = new Scene(titleLayout, 600, 480);
        window.setScene(titleScene);


        //Create Character
        createCharacterLayout.getChildren().addAll(createCharacterLabel, characterName, knightRadio, wizardRadio, archerRadio, createCharacterButton);
        createCharacterScene = new Scene(createCharacterLayout, 600, 480);

        //Game
        gameLayout.getChildren().addAll(fightButton, cityButton, characterStatsButton);
        gameScene = new Scene(gameLayout, 600, 480);

        //Fight
        victoryButton.setDisable(true);
        victoryButton.setVisible(false);
        defeatButton.setDisable(true);
        defeatButton.setVisible(false);
        fightScene = new Scene(fightLayout, 600, 480);

        //City
        cityLayout.getChildren();
        cityScene = new Scene(cityLayout, 600, 480);

        //Character Stats
        characterStatsLayout.getChildren().addAll(characterStatsName, characterStatsHealth, characterStatsLevel, characterStatsExp, characterStatsPower, characterStatsStamina, characterStatsAgility, characterStatsIntellect, characterStatsGold, backToGameButton);
        characterStatsScene = new Scene(characterStatsLayout, 600, 480);

        //Victory
        victoryLayout.getChildren().addAll(itemReward, goldReward, expReward, continueButton);
        victoryScene = new Scene(victoryLayout, 600, 480);

        window.show();
        StyleManager.getInstance().addUserAgentStylesheet("com/company/style.css");


        //Elements
        startButton.setOnAction(e -> {
            window.setScene(createCharacterScene);
        });

        createCharacterButton.setOnAction(e -> {
            player = new PlayerStats(characterName.getText(), playerClass, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], stats[6], 0, 1, 100);
            System.out.println("Character Created: ");
            System.out.println("Name: " + player.getName());
            System.out.println("Class: " + player.getClassName());
            System.out.println("Health: " + player.getHealth());
            System.out.println("Power: " + player.getPower());
            System.out.println("Stamina: " + player.getStamina());
            System.out.println("Agility: " + player.getAgility());
            System.out.println("Intellect: " + player.getIntellect());
            playerHealth = new Label(player.getName() + ": " + player.getHealth());
            window.setScene(gameScene);
        });

        knightRadio.setSelected(true);
        if(knightRadio.isSelected()) {
            playerClass = "Knight";
            stats[0] = 100;  //Base Health
            stats[1] = 106;  //Health
            stats[2] = 100;  //Max Health
            stats[3] = 10;   //Power
            stats[4] = 6;    //Stamina
            stats[5] = 5;    //Agility
            stats[6] = 4;    //Intellect
        }
        knightRadio.setOnAction(e -> {
            playerClass = "Knight";
            stats[0] = 100;  //Base Health
            stats[1] = 106;  //Health
            stats[2] = 106;  //Max Health
            stats[3] = 10;   //Power
            stats[4] = 6;    //Stamina
            stats[5] = 5;    //Agility
            stats[6] = 4;    //Intellect
        });

        wizardRadio.setOnAction(e -> {
            playerClass = "Wizard";
            stats[0] = 100;  //Base Health
            stats[1] = 105;  //Health
            stats[2] = 105;  //Max Health
            stats[3] = 6;    //Power
            stats[4] = 5;    //Stamina
            stats[5] = 5;    //Agility
            stats[6] = 10;   //Intellect
        });

        archerRadio.setOnAction(e -> {
            playerClass = "Archer";
            stats[0] = 100;  //Base Health
            stats[1] = 108;  //Health
            stats[2] = 108;  //Max Health
            stats[3] = 7;    //Power
            stats[4] = 8;    //Stamina
            stats[5] = 10;   //Agility
            stats[6] = 5;    //Intellect
        });

        fightButton.setOnAction(e -> {
            window.setScene(fightScene);
            levelUpLabel.setVisible(false);
            String enemyName = enemyNames[(RNG(enemyNames.length))];


            enemy = new EnemyStats(enemyName, player.getBaseHealth(), player.getHealth(), player.getPower(), player.getStamina(), player.getAgility(), player.getIntellect());
            System.out.println("Enemy Encountered: ");
            System.out.println("Name: " + enemy.getName());
            enemyHealth = new Label((enemy.getName() + ": " + enemy.getHealth()));
            fightLayout.getChildren().addAll(playerHealth, enemyHealth, lightAttackButton, heavyAttackButton, victoryButton, defeatButton);
        });

        cityButton.setOnAction(e -> window.setScene(cityScene));

        characterStatsButton.setOnAction(e -> {
            window.setScene(characterStatsScene);
            characterStatsName.setText(("Name: " + player.getName()));
            characterStatsHealth.setText(("Health: " + player.getHealth() + "\n"));
            characterStatsLevel.setText(("Level: " + player.getLevel()));
            characterStatsExp.setText(("Exp: " + player.getExp() + "\n"));
            characterStatsPower.setText(("Power: " + player.getPower()));
            characterStatsStamina.setText(("Stamina: " + player.getStamina()));
            characterStatsAgility.setText(("Agility: " + player.getAgility()));
            characterStatsIntellect.setText("Intellect: " + player.getIntellect() + "\n");
            characterStatsGold.setText(("Gold: " + player.getGold()));
        });

        backToGameButton.setOnAction(e -> window.setScene(gameScene));

        lightAttackButton.setOnAction(e -> {
            int dmg = calculateDamage(1);
            enemy.setHealth((enemy.getHealth() - dmg));
            System.out.println("Enemy took " + dmg + " points of damage.");
            System.out.println(enemy.getName() + ": " + enemy.getHealth());
            enemyHealth.setText(enemy.getName() + ": " + enemy.getHealth());
            if(enemy.getHealth() <= 0) {
                enemyHealth.setText(enemy.getName() + ": " + 0);
                lightAttackButton.setDisable(true);
                heavyAttackButton.setDisable(true);

                victoryButton.setDisable(false);
                victoryButton.setVisible(true);
                victory();
            }

            int enemyDmg = enemyAttack();
            player.setHealth((player.getHealth() - enemyDmg));
            System.out.println("Player took " + enemyDmg + " points of damage.");
            System.out.println(player.getName() + ": " + player.getHealth());
            playerHealth.setText(player.getName() + ": " + player.getHealth());
            if(player.getHealth() <= 0) {
                playerHealth.setText(player.getName() + ": " + 0);
                lightAttackButton.setDisable(true);
                heavyAttackButton.setDisable(true);

                defeatButton.setDisable(false);
                defeatButton.setVisible(true);
                defeat();
            }
        });

        heavyAttackButton.setOnAction(e -> {
            int dmg = calculateDamage(2);
            enemy.setHealth((enemy.getHealth() - dmg));
            System.out.println("Enemy took " + dmg + " points of damage.");
            System.out.println(enemy.getName() + ": " + enemy.getHealth());
            enemyHealth.setText(enemy.getName() + ": " + enemy.getHealth());
            if(enemy.getHealth() <= 0) {
                enemyHealth.setText(enemy.getName() + ": " + 0);
                lightAttackButton.setDisable(true);
                heavyAttackButton.setDisable(true);

                victoryButton.setDisable(false);
                victoryButton.setVisible(true);
                victory();
            }

            int enemyDmg = enemyAttack();
            player.setHealth((player.getHealth() - enemyDmg));
            System.out.println("Player took " + enemyDmg + " points of damage.");
            System.out.println(player.getName() + ": " + player.getHealth());
            playerHealth.setText(player.getName() + ": " + player.getHealth());
            if(player.getHealth() <= 0) {
                playerHealth.setText(player.getName() + ": " + 0);
                lightAttackButton.setDisable(true);
                heavyAttackButton.setDisable(true);

                defeatButton.setDisable(false);
                defeatButton.setVisible(true);
                defeat();
            }
        });

        victoryButton.setOnAction(e -> window.setScene(victoryScene));
        defeatButton.setOnAction(e -> window.setScene(defeatScene));
        continueButton.setOnAction(e -> window.setScene(gameScene));
    }

    private static int RNG(int num) {
        int rand = (int) (Math.floor(Math.random() * num));

        return rand;
    }

    private int calculateDamage(int attackType) {
        int dmg = 0;
        if(attackType == 1) {
            dmg = RNG(player.getPower());
        }else if(attackType == 2) {
            dmg = RNG((player.getPower() * 2));
        }
        return dmg;
    }

    private int enemyAttack() {
        int dmg = RNG(enemy.getPower());
        return dmg;
    }

    private void victory() {
        player.setHealth(player.getMaxHealth());

        goldReward.setText("Gold Received: 50");
        player.setGold((player.getGold() + 50));

        expReward.setText("Exp Gained: 100");
        player.setExp((player.getExp() + 100));

        boolean canLevelUp = checkForLevelUp();
        if(canLevelUp) {
            player.setLevel((player.getLevel() + 1));
            levelUpLabel.setVisible(true);
        }
    }

    private void defeat() {
        System.out.println("You died");
    }

    private boolean checkForLevelUp() {
        boolean levelUp = false;
        switch (player.getExp()) {
            case 300:
                levelUp = true;
                break;
            case 600:
                levelUp = true;
                break;
            case 900:
                levelUp = true;
                break;
            case 1200:
                levelUp = true;
                break;
            case 1500:
                levelUp = true;
                break;
            case 1800:
                levelUp = true;
                break;
            case 2100:
                levelUp = true;
                break;
            case 2400:
                levelUp = true;
                break;
            case 2700:
                levelUp = true;
                break;
            case 3000:
                levelUp = true;
                break;
            default:
                levelUp = false;
                break;
        }
        return levelUp;
    }
}
