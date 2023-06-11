package DatabaseAccess;

import Exceptions.AnnotationMissingException;
import Exceptions.EmptyIDException;
import Exceptions.MissingBarAnnotationException;
import Exceptions.MissingIdException;
import Program.Entities.Movie;
import Reflection.ObjectReflection;
import SQL.SQLBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Manager {

    public <T> T getEntitByID(Long id, Class<T> inputClass) throws EmptyIDException, AnnotationMissingException, MissingBarAnnotationException, MissingIdException, SQLException, InstantiationException, IllegalAccessException {

        T o = null;
        if(id == null){
            throw new EmptyIDException("ID CANNOT BE EMPTY");
        }

        if(!ObjectReflection.isTable(inputClass)){
            throw new AnnotationMissingException("Annotation is missing");
        }

        ResultSet result = loadData(id,inputClass);
        System.out.println(result.getString("Address"));

        o = ObjectReflection.getFilledData(result,inputClass);

        return o;
    }

    private <T> ResultSet loadData(Long id, Class<T> inputClass) throws MissingBarAnnotationException, MissingIdException {
        String tableName = ObjectReflection.getTableName(inputClass);
        List<String> tableBars = ObjectReflection.getBarNames(inputClass);
        String idBarName = ObjectReflection.getIDBarName(inputClass);

        String query = SQLBuilder.buildQuery(id,tableName,idBarName,tableBars);
        System.out.println(query);

        DatabaseAccess databaseAccess = new DatabaseAccess();

        return databaseAccess.executeQuery(query);
    }

    public <T> void insertEntity(T object) {
            Class<?> inputClass = object.getClass();
            String tableName = ObjectReflection.getTableName(inputClass);
            List<String> tableBars = ObjectReflection.getBarNames(inputClass);

            Map<String,Object> data = ObjectReflection.getObjectData(inputClass);
            String query = SQLBuilder.buildInsertQuery(tableName,tableBars,data);

            DatabaseAccess databaseAccess = new DatabaseAccess();
            databaseAccess.insert(query);

        System.out.println(query);

            //insert into MOVIE (Director,Starring,ID) Values ('','',0);
    }
}
