package com.safersolutions;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        //O método launch(args), faz o 'setup' da classe Application.
        launch(args);
    }

    @Override
    //Em JavaFX a janela em sua totalidade eh chamada de 'Stage', o conteudo dentro dela se chama 'Scene'
    public void start(Stage primaryStage) throws Exception {
        Button testButton;
        
        //To.do o código de JavaFX vem aqui.
        primaryStage.setTitle("Crew Management Tool 0.0.1");
        testButton = new Button("Click");

        //Aqui eh onde iremos configurar o layout do Stage:
        StackPane layout = new StackPane();
        layout.getChildren().add(testButton);

        //Aqui eh onde criamos uma Scene e atribuimos ela ao Stage:
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
