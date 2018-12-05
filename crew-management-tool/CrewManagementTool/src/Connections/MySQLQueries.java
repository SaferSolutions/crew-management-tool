package Connections;

public class MySQLQueries {
    private String query_select = "SELECT ";
    private String query_insert = "INSERT INTO ";

    public String queryInsert(String query_table, String query_insert_value){
        String query_insert_final = query_insert + query_table + " VALUES(default, " + query_insert_value + ");";
        System.out.println(query_insert_final);
        return query_insert_final;
    }

// nome_funcionario varchar(50) not null,
//    cpf_funcionario varchar(14) not null,
//    rg_funcionario varchar(13),
//    empresa_afiliada int(11),
//    endereco_funcionario int(11),
//    salario double(10,2) not null,
//    gasto_individual int(11),
//    viabilidade_remota int,
}
