package Reflection;

import Anotations.Bar;
import Anotations.ID;
import Anotations.Table;
import Exceptions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectReflection {

    public static <T> boolean isTable(Class<T> inputClass) {
        return inputClass.isAnnotationPresent(Table.class);
    }

    public static <T> String getTableName(Class<T> inputClass) {
        return inputClass.getAnnotation(Table.class).value();
    }

    public static <T> List<String> getBarNames(Class<T> inputClass) {
        List<String> bars = new ArrayList<>();
        for(Field f : inputClass.getDeclaredFields()){
            if(f.isAnnotationPresent(Bar.class)){
                 Bar bar = f.getAnnotation(Bar.class);
                 bars.add(bar.value());
                 System.out.println("Stlpec: "+bar.value());
            }
        }
        return bars;
    }

    public static <T> String getIDBarName(Class<T> inputClass) throws MissingBarAnnotationException, MissingIdException {
        String idBarName = null;
        for(Field f : inputClass.getDeclaredFields()){
            if(f.isAnnotationPresent(ID.class)){
                if(f.isAnnotationPresent(Bar.class)){
                    idBarName = f.getAnnotation(Bar.class).value();
                } else {
                    throw new MissingBarAnnotationException("No ID found with bar");
                }
            }
        }
        if(idBarName == null)
            throw new MissingIdException("No ID found");

        System.out.println("ID: "+idBarName);
        return idBarName;
    }

    public static <T> T getFilledData(ResultSet result, Class<T> inputClass) throws IllegalAccessException, InstantiationException, SQLException {
        T object = null;


            object = inputClass.newInstance();

            for(Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Bar.class)) {
                    String typElementu = f.getType().getName();
                    String nazovStlpca = f.getAnnotation(Bar.class).value();

                    if (typElementu.equals(String.class.getName())) {
                        f.set(object, result.getString(nazovStlpca));
                    } else if (typElementu.equals(Long.class.getName())) {
                        f.set(object, result.getLong(nazovStlpca));
                    } else if (typElementu.equals(Integer.class.getName())) {
                        f.set(object, result.getInt(nazovStlpca));

                    }
                }
            }

            return object;

    }

}
