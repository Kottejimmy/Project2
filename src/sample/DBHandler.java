package sample;

<<<<<<< HEAD


=======
>>>>>>> bae0b6e6eabf970b28b1725a921a4325b39432a9
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class DBHandler {
    private final String dbName;
    private final String user;
    private final String password;
    private final String connectionURL;

    public DBHandler() {
        Properties p = loadProperties();
        dbName = p.getProperty("dbName");
        user = p.getProperty("user");
        password = p.getProperty("password");
        connectionURL = "jdbc:mysql://localhost/" + dbName + "?user=" + user + "&password=" + password + "&useSSL=false";
    }

    private Properties loadProperties() {
        Properties appProp = new Properties();
        try (FileInputStream fis = new FileInputStream("DB.properties")) {
            appProp.load(fis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return appProp;
    }


    public void printAll() {
        try (Connection conn = DriverManager.getConnection(connectionURL)) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM team");

            while (rs.next()) {
                System.out.printf("%s%n", rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPlayerToDB(String name, String surName, String position, String teamName, String userName, String password) {

        try (Connection conn = DriverManager.getConnection(connectionURL)) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `player` (Firstname,Surname,Playerposition,team_name,Password) VALUE (?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, surName);
            pstmt.setString(3, position);
            pstmt.setString(4, teamName);
            pstmt.setString(5, password);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlayerFromDB(int index) {
        try (Connection conn = DriverManager.getConnection(connectionURL)) {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM player WHERE PlayerID=" + index);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMatchToDB(String date, String opponent){
        try(Connection conn = DriverManager.getConnection(connectionURL)){
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO `match` (Date,Opponents) VALUE (?,?)");
            pstm.setString(1, date);
            pstm.setString(2, opponent);
            pstm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeMatchFromDB (int id){

        try(Connection conn = DriverManager.getConnection(connectionURL)){
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM `match` WHERE `MatchID` = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public boolean handleLoginCoach(String userName, String password) {
        boolean result = false;
        try(Connection conn = DriverManager.getConnection(connectionURL)) {
            Statement pstm = conn.createStatement();
            ResultSet rs=pstm.executeQuery("SELECT * FROM coach where Username='" + userName + "'and Password='" + password + "'");
           if(rs.next()) {
               String checkUser = rs.getString(1);
               String checkPass = rs.getString(2);


               if (checkUser.equals(userName) && checkPass.equals(password)) {
                   result = true;
                   System.out.println(result);
               } else {
                   result = false;
                   System.out.println(result);
               }

           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }





    }








