package at.hakimst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        try{

            Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");

        }catch (SQLException e){

            throw new RuntimeException("Db Verbindung nicht möglich");

        }
        }catch (ClassNotFoundException e) {

            throw new RuntimeException("Treiber nicht gefunden");

        }
    }
}