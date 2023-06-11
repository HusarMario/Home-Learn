package main.java.SQL;

import java.util.List;

public class SQLBuilder {

    public static String buildQuery(Long id, String tableName, List<String> tableCoulmns, String idCoulmnName) {
        StringBuilder columns = new StringBuilder();
        for (String s : tableCoulmns){
            columns.append(s).append(",");
        }
        String query = columns.toString().substring(0,columns.lastIndexOf(","));
        return String.format("SELECT %s FROM %s WHERE %s=%d",query,tableName,idCoulmnName,id);
    }
}
