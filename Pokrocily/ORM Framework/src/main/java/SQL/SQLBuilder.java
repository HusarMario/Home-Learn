package SQL;

import java.util.List;

public class SQLBuilder {
    public static String buildQuery(Long id, String tableName, String idBarName, List<String> tableBars) {

        StringBuilder bars = new StringBuilder();
        for(String s : tableBars){
            bars.append(s).append(",");

        }
        String barsQuery = bars.toString().substring(0,bars.lastIndexOf(","));

        return String.format("SELECT %s FROM %s WHERE %s=%d",barsQuery,tableName,idBarName,id);
    }
}
