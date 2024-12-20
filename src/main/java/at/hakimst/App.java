package at.hakimst;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        selectAllMitschueler();
        insertMitschueler("Markus","PS5 spielen");
        selectAllMitschueler();
        updateMitschueler(3,"Ben","Radfahren");
        selectAllMitschueler();
        deleteMitschueler(3);
        selectAllMitschueler();
        findAllMitschuelerByNameLike("Rob");
    }
    private static void findAllMitschuelerByNameLike(String pattern) {
        System.out.println("Find all by Name Mitschueler mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbc_aa2";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `hobbies` WHERE `hobbies`.`mitschueler` LIKE ?");
            preparedStatement.setString(1,"%"+pattern+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String mitschueler = rs.getString("mitschueler");
                String hobby = rs.getString("hobby");
                System.out.println("Student aus der DB: [ID] " + id + " [NAME]" + mitschueler + " [HOBBY]" + hobby);
            }

        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }

    }

    public static void deleteMitschueler(int hobbyId)
    {
        System.out.println("DELETE Mitschueler mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbc_aa2";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM `hobbies` WHERE `hobbies`.`id`=?");
            try
            {
                preparedStatement.setInt(1,hobbyId);
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Anzahl der gelöschten Datensätze: " + rowAffected);
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-DELETE Statement: " + ex.getMessage());
            }

        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }
    }
    public static void updateMitschueler(int id, String neuerMitschueler, String neuesHobby)
    {
        System.out.println("UPDATE Mitschueler mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbc_aa2";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE `hobbies` SET `mitschueler` = ?, `hobby` = ? WHERE `hobbies`.`id`= ?");
            try
            {
                preparedStatement.setString(1,neuerMitschueler);
                preparedStatement.setString(2,neuesHobby);
                preparedStatement.setInt(3,id);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Anzahl der aktualisierten Datensätze: " +affectedRows);
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-UPDATE Statement: " + ex.getMessage());
            }

        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }
    }
    public static void insertMitschueler(String mitschueler, String hobby)
    {
        System.out.println("INSERT Mitschueler mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jdbc_aa2";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO `hobbies` (`id`, `mitschueler`, `hobby`) VALUES (NULL, ?, ?)");
            try
            {
                preparedStatement.setString(1,mitschueler);
                preparedStatement.setString(2,hobby);
                int rowAffected =  preparedStatement.executeUpdate();
                System.out.println(rowAffected + "Datensätze eingefügt");
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-INSERT Statement: " + ex.getMessage());
            }

        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }
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
