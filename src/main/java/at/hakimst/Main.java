package at.hakimst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Markus Grün', 'margruen@myimst.at'), (NULL, 'Maria Koenne', 'mariakoenne@myimst.at');

public class Main {
    public static void main(String[] args) {
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Alexander Klapeer', 'alklapeer@tsn.at'), (NULL, 'maria könne', 'maria.koenne@myimst.at');

        selectAllDemo();


//        try {

//            Class.forName("com.mysql.cj.jdbc.Driver");

//            try {

//                Connection com = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");

//            }catch(SQLException e) {

//                throw new RuntimeException("Die Verbindung nicht möglich");

//            }

//        }

//        catch(ClassNotFoundException e){

//            throw new RuntimeException("Treiber nicht gefunden!");

//        }

    }

    public static void selectAllDemo() {

        System.out.println("Select DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `student");
        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }

    }
}