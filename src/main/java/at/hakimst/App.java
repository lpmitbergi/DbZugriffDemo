package at.hakimst;

import java.sql.*;

public class App {
    public static void main(String[] args) {

    }
    public static void selectAllMitschueler() {

        System.out.println("Select Mitschueler mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbc_aa2";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `hobbies`");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("mitschueler");
                String hobby = rs.getString("hobby");
                System.out.println("Mitschueler aus der DB: [ID] " + id + " [NAME]" + name + " [HOBBY]" + hobby);
            }

        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }

    }
}
