package com.safersolutions;

//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//Início da classe de conexão//
public class con_sql{

    public static String status = "Não conectou...";

    //Método Construtor da Classe//
    public con_sql() {

    }

    //Método de Conexão//
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;   //atributo do tipo Connection

        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //nome do servidor mysql

            String mydatabase = "banco_safer";  //nome do banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";   //nome de um usuário do banco

            String password = ""; //senha de acesso do banco

            connection = DriverManager.getConnection(url, username, password);

            //Testa a conexão//
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");

            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {  // se Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

        //se houver falha na conexão com o banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    //Método que retorna o status da conexão//
    public static String statusConection() {
        return status;

    }

    //Método que fecha a conexão//

    public static boolean FecharConexao() {
        try {
            con_sql.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    //Método que reinicia a conexão//

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();

        return con_sql.getConexaoMySQL();

    }

}
