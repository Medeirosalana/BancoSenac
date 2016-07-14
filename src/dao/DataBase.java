package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DATABASE = URL + "db_banco_senac";
    private final String USER = "root";
    private final String PASSWORD = "senac";

    public boolean Connect() {
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE, USER, PASSWORD );
            return true;        
        }catch(ClassNotFoundException erro){
            System.out.println("Driver não encontrado");
            System.out.println("ERRO: " + erro);
        return false;
        }catch(SQLException erro){
            System.out.println("Falha na conecxão");
            System.out.println("ERRO: " + erro);            
        return false;
        }       
    }
    public boolean discconect(){
    try{
    connection.close();
        System.out.println("desconectou");    
    return true;
    }catch(SQLException erro){
        System.out.println("falha ao desconectar");
        System.out.println("ERRO: "+ erro);
        return false;
    }
        }
    
}
