package com.safersolutions;

public class MySQLQueries {
    private String query_select = "SELECT ";
    private String query_insert = "INSERT INTO ";

    public String queryInsert(String query_table, String query_insert_value){
        String query_insert_final = query_insert + query_table + " VALUES(default, " + query_insert_value + ");";
        System.out.println(query_insert_final);
        return query_insert_final;
    }


}
