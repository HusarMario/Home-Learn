package main.java;

import main.java.DatabaseAccess.Manager;
import java.sql.*;

public class Main {


    public static void main(String[] args) {
        Manager manager = new Manager();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","261299");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * from Movie");
            while (resultSet.next())
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Done");
        }
    }




}
