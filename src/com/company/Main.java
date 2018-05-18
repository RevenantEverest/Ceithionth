package com.company;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) { launch(args); }

    private Button startButton;
    private Scene newGameScene, createCharacterScene, fightScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Acirhia");
        startButton = new Button("Start Game");
        startButton.setOnAction(e -> System.out.println("Starting new game"));

        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);

        Scene startMenu = new Scene(layout, 600, 480);
        primaryStage.setScene(startMenu);
        primaryStage.show();
        StyleManager.getInstance().addUserAgentStylesheet("com/company/style.css");
    }
}
