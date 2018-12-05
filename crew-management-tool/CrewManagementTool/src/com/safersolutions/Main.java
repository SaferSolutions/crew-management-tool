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

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main extends Application {


    public static void main(String[] args) {
        //O método launch(args), faz o 'setup' da classe Application.


        launch(args);

    }

    @Override
    //Em JavaFX a janela em sua totalidade eh chamada de 'Stage', o conteudo dentro dela se chama 'Scene'
    public void start(Stage primaryStage) throws Exception {
        ConnectionSQL.getConexaoMySQL();
        FXMLLoader loadMainMenu = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        FXMLLoader loadInsertFunc = new FXMLLoader(getClass().getResource("InsertFunc.fxml"));

        Controller controller = new Controller();
        loadMainMenu.setController(controller);


        Parent rootMainMenu = loadMainMenu.load();
        Parent rootInsertFunc = loadInsertFunc.load();

        primaryStage.setTitle("CMT - Crew Management Tool");
        primaryStage.setScene(new Scene(rootMainMenu, 640, 400));
        primaryStage.show();
        //dep = departamento.
        primaryStage.show();

        //Aqui vem a parte logica do codigo
        //Lidamos com o evento de clique do botao de inserir novo funcionario
        controller.addNewFunc.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                //sc = scene

                    Scene scCadFunc = new Scene(rootInsertFunc, 640, 400);
                    primaryStage.setScene(scCadFunc);
                    primaryStage.setTitle("Novo usuário");

//

            }
        });

        if(primaryStage.getTitle().equals("Novo usuário")){
            ConnectionSQL.ps.setString(1, controller.funcNome.toString());
            ConnectionSQL.ps.setString(2, controller.funcCPF.toString());
            ConnectionSQL.ps.setString(3, controller.funcRG.toString());
            ConnectionSQL.ps.setInt(4, Integer.parseInt(controller.funcDist.toString()));
            ConnectionSQL.ps.setDouble(5,Double.parseDouble(controller.funcSalario.toString()));
            ConnectionSQL.ps.setInt(6,Integer.parseInt(controller.funcGastos.toString()));

                    controller.sendInfoFunc.setOnAction(new EventHandler<ActionEvent>(){
                    @Override public void handle(ActionEvent e) {
                        try{
                            ConnectionSQL.ps.execute();
                        }catch(SQLException ex){
                            System.out.println("Erro ao inserir dados.");
                        }

                    }
                });

        }








    }
}
