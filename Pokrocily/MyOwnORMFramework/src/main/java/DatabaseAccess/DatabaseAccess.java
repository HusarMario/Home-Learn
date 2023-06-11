package main.java.DatabaseAccess;

import java.sql.ResultSet;

public class DatabaseAccess {

    public ResultSet executeQuery(String query) {
        return new ResultSetImpl();
    }
}
