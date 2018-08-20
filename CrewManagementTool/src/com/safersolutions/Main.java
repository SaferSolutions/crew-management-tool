package com.safersolutions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        //O método launch(args), faz o 'setup' da classe Application.
        launch(args);
    }

    @Override
    //Em JavaFX a janela em sua totalidade eh chamada de 'Stage', o conteudo dentro dela se chama 'Scene'
    public void start(Stage primaryStage) throws Exception {
        //dep = departamento.

        Label introText, welcomeText;
        TextField depName;
        Button addDepButton;

        //To.do o codigo de JavaFX vem aqui.
        primaryStage.setTitle("Crew Management Tool 0.0.1");
        welcomeText = new Label("Bem vindo!");
        introText = new Label("Para começar adicione um novo departamento com que deseja administrar: ");

        depName = new TextField();
        addDepButton = new Button("Add");


        //Aqui eh onde iremos configurar o layout do Stage:
        Pane layout = new Pane();
        layout.getChildren().addAll(welcomeText, introText, depName, addDepButton);

        //Aqui posicionamos os objetos dentro da Scene
        //welcomeText
        welcomeText.setLayoutX(10);
        welcomeText.setLayoutY(50);

        //introText
        introText.setLayoutX(10);
        introText.setLayoutY(100);

        //depName
        depName.setLayoutX(10);
        depName.setLayoutY(200);

        //addDepButton
        addDepButton.setLayoutX(10);
        addDepButton.setLayoutY(250);


        //Aqui eh onde criamos uma Scene e atribuimos ela ao Stage:
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
