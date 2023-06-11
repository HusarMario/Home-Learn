package main.java.DatabaseAccess;

import main.java.Exceptions.ClassTableNotImplementedException;
import main.java.Exceptions.ColumnIdMissmatchException;
import main.java.Exceptions.InvalidIDException;
import main.java.Exceptions.NoIdFoundException;
import main.java.Objects.Movie;
import main.java.Reflection.ObjectReflection;
import main.java.SQL.SQLBuilder;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Manager {

    public <O> O getByID(Long id, Class<O> inputClass) throws InvalidIDException, ClassTableNotImplementedException, ColumnIdMissmatchException, NoIdFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException, IllegalAccessException {
        O object = null;

        if(id == null){
            throw new InvalidIDException();
        }

        if(!ObjectReflection.isTable(inputClass)){
            throw new ClassTableNotImplementedException();
        }

        ResultSet resultSet = loadData(id,inputClass);

        object = ObjectReflection.getFilledData(resultSet,inputClass);

        return object;
    }



    private <O> ResultSet loadData(Long id, Class<O> inputClass) throws ColumnIdMissmatchException, NoIdFoundException {
        String tableName = ObjectReflection.getTableName(inputClass);
        List<String> tableCoulmns = ObjectReflection.getColumnNames(inputClass);
        String idCoulmnName = ObjectReflection.getIdCoulmnName(inputClass);

        String query = SQLBuilder.buildQuery(id,tableName,tableCoulmns,idCoulmnName);
        System.out.println(query);

        DatabaseAccess databaseAccess = new DatabaseAccess();
        return databaseAccess.executeQuery(query);
        
    }

}
