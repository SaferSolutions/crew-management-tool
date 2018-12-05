package com.safersolutions;
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
import Connections.ConnectionSQL;
import Connections.MySQLQueries;

// nome_funcionario varchar(50) not null,
//    cpf_funcionario varchar(14) not null,
//    rg_funcionario varchar(13),
//    empresa_afiliada int(11),
//    endereco_funcionario int(11),
//    salario double(10,2) not null,
//    gasto_individual int(11),
//    viabilidade_remota int,

public class RegisterUser extends Application{
    Pane lyUserReg = new Pane();
    TextField tfCPF, tfRG, tfEmpresaAfiliada, tfAddres, tfSalary, tfGasto, tfViabilidade, tfName;
    Button subButton = new Button("Submit");

    @Override
    public void start(Stage primaryStage) {
        ConnectionSQL.getConexaoMySQL();
        tfName = new TextField();
        tfAddres = new TextField();
        tfCPF = new TextField();
        tfEmpresaAfiliada = new TextField();
        tfGasto = new TextField();
        tfRG = new TextField();
        tfSalary = new TextField();
        tfViabilidade = new TextField();

        primaryStage.setTitle("Insert TEST");

        lyUserReg.getChildren().addAll(tfAddres, tfCPF, tfEmpresaAfiliada, tfGasto, tfRG, tfSalary, tfViabilidade, tfName, subButton);

        //Endereco
        tfAddres.setLayoutX(10);
        tfAddres.setLayoutY(50);

        //CPF
        tfCPF.setLayoutX(10);
        tfCPF.setLayoutY(100);

        //Empresa
        tfEmpresaAfiliada.setLayoutX(10);
        tfEmpresaAfiliada.setLayoutY(150);

        //Gasto
        tfGasto.setLayoutX(10);
        tfGasto.setLayoutY(200);

        //RG
        tfRG.setLayoutX(10);
        tfRG.setLayoutY(250);

        //Salario
        tfSalary.setLayoutX(10);
        tfSalary.setLayoutY(300);

        //Viabilidade
        tfViabilidade.setLayoutX(10);
        tfViabilidade.setLayoutY(350);

        //Nome
        tfName.setLayoutX(10);
        tfName.setLayoutY(400);

        Scene scUserRes = new Scene(lyUserReg, 800, 600);
        primaryStage.setScene(scUserRes);
        primaryStage.show();

        subButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                String userName = tfName.getText();
                String userAddress = tfAddres.getText();
                String userCPF = tfCPF.getText();
                String userEmpresa = tfEmpresaAfiliada.getText();
                String userGasto = tfGasto.getText();
                String userRG = tfRG.getText();
                String userSalary = tfSalary.getText();
                String userViabilidade = tfViabilidade.getText();

                String fullInsert = userName +","+ userCPF +","+ userRG +","+ userEmpresa +","+ userAddress +","+ userSalary +","+ userGasto +","+ userViabilidade;
                MySQLQueries query = new MySQLQueries();

                query.queryInsert("funcionario", fullInsert);




                }
        });

    }
}
