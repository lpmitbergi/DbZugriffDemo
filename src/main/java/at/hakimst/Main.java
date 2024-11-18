package at.hakimst;

import java.sql.*;

//INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Markus Grün', 'margruen@myimst.at'), (NULL, 'Maria Koenne', 'mariakoenne@myimst.at');

public class Main {
    public static void main(String[] args) {
        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Alexander Klapeer', 'alklapeer@tsn.at'), (NULL, 'maria könne', 'maria.koenne@myimst.at');

        selectAllDemo();
        insertStudentDemo("Name des Studenten", "Email@prov.at");
        selectAllDemo();
        updateStudentDemo(6,"Neuer Name", "neueEmail@provider.at");
        selectAllDemo();
        deleteStudentDemo(7);
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

    public static void deleteStudentDemo(int studentId)
    {
        System.out.println("DELETE DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jbcdemo";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM `student` WHERE `student`.`id`=?");
            try
            {
                preparedStatement.setInt(1,studentId);
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

    public static void updateStudentDemo(int id, String neuerName, String neueEmail)
    {
        System.out.println("UPDATE DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jbcdemo";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE `student` SET `name` = ?, `email` = ? WHERE `student`.`id`= ?");
            try
            {
                preparedStatement.setString(1,neuerName);
                preparedStatement.setString(2,neueEmail);
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
    public static void insertStudentDemo(String name, String email)
    {
        System.out.println("INSERT DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jbcdemo";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)");
            try
            {
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,email);
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

    public static void selectAllDemo() {

        System.out.println("Select DEMO mit JDBC");

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jbcdemo";

        String user = "root";

        String pwd = "";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, pwd);) {

            System.out.println("Verbindung zur DB hergestellt!");

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `student`");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Student aus der DB: [ID] " + id + " [NAME]" + name + " [EMAIL]" + email);
            }

        } catch (SQLException e) {

            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }

    }
}