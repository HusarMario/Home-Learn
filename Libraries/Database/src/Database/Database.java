package Database;

import Database.Exceptions.FailedToExecuteException;
import Database.Exceptions.NullInputStreamException;
import Database.Exceptions.NullPropertyFieldException;

import java.io.IOException;
import java.sql.*;

public class Database {

    private Connection connection = null;
    private PropertiesReader propertiesReader = null;

    public Database() {
        try{
            propertiesReader = new PropertiesReader();
        } catch (NullInputStreamException | NullPropertyFieldException | IOException exception){
            exception.printStackTrace();
        }
    }

    public void check(){
        System.out.println(propertiesReader);
    }

    public void connect(){
        try{
            Class.forName(propertiesReader.driver);
            connection = DriverManager.getConnection(propertiesReader.url,propertiesReader.user,propertiesReader.pass);
            if(connection != null){
                connection.setAutoCommit(false);
            } else throw new SQLException("Connection is null");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet executeQuery(String input) throws FailedToExecuteException {

        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(input);
        }catch (SQLException e){
            e.printStackTrace();
        }

        throw new FailedToExecuteException();
    }

    public void disconnect(){
        try{
        connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void commit(){
        try{
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void rollBack(){
        try{
            connection.rollback();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
