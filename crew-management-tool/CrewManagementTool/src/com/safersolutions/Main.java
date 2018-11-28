package com.safersolutions;

import Connections.ConnectionSQL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Crew Management Tool 0.0.7");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        //dep = departamento.
        primaryStage.show();

        //Aqui vem a parte logica do codigo
        //Lidamos com o evento de clique do botao de cadastrar novo depto
//        addDepButton.setOnAction(new EventHandler<ActionEvent>(){
//            @Override public void handle(ActionEvent e) {
//                //sc = scene
//
//                if(depName.getText().isEmpty()){
//                    //Alerta caso o usuario nao preencha o campo de nome do departamento
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Erro!");
//                    alert.setHeaderText("Um ou mais campos não foram preenchidos!");
//                    alert.showAndWait();
//                }else{
//                    Scene scCadDepto = new Scene(lyCadDepto, 800, 600);
//                    primaryStage.setScene(scCadDepto);
//
//                }
//
//
//
//
//
//
//            }
//        });




    }
}
