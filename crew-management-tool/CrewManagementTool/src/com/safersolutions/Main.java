package com.safersolutions;

import Connections.ConnectionSQL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;




public class Main extends Application {


    public static void main(String[] args) {
        //O método launch(args), faz o 'setup' da classe Application.


        launch(args);

    }

    @Override
    //Em JavaFX a janela em sua totalidade eh chamada de 'Stage', o conteudo dentro dela se chama 'Scene'
    public void start(Stage primaryStage) throws Exception {


        ConnectionSQL.getConexaoMySQL();

        //dep = departamento.

        Label introText, welcomeText;
        TextField depName;
        Button addDepButton;


        primaryStage.setTitle("Crew Management Tool 0.0.1");
        welcomeText = new Label("Bem vindo!");
        introText = new Label("Para começar adicione um novo departamento com que deseja administrar: ");

        depName = new TextField();
        addDepButton = new Button("Add");


        //Aqui eh onde iremos configurar o layout da Scene de boas vindas:
        //ly = layout
        Pane lyWelcome = new Pane();
        lyWelcome.getChildren().addAll(welcomeText, introText, depName, addDepButton);

        //o layout da Scene de cadastro de departamento:
        Pane lyCadDepto = new Pane();

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
        Scene scene = new Scene(lyWelcome, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();

        //Aqui vem a parte logica do codigo
        //Lidamos com o evento de clique do botao de cadastrar novo depto
        addDepButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                //sc = scene

                if(depName.getText().isEmpty()){
                    //Alerta caso o usuario nao preencha o campo de nome do departamento
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText("Um ou mais campos não foram preenchidos!");
                    alert.showAndWait();
                }else{
                    Scene scCadDepto = new Scene(lyCadDepto, 800, 600);
                    primaryStage.setScene(scCadDepto);

                }






            }
        });




    }
}
