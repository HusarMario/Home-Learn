package main.java.Reflection;

import main.java.Annotations.Column;
import main.java.Annotations.ID;
import main.java.Annotations.Table;
import main.java.Exceptions.ColumnIdMissmatchException;
import main.java.Exceptions.NoIdFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjectReflection {

    public static <O> boolean isTable(Class<O> inputClass) {
        return inputClass.isAnnotationPresent(Table.class);
    }

    public static <O> String getTableName(Class<O> inputClass) {
        return inputClass.getAnnotation(Table.class).value();
    }

    public static <O> List<String> getColumnNames(Class<O> inputClass) {
        List<String> columns = new ArrayList<>();
        for(Field field : inputClass.getDeclaredFields()){
            if(field.isAnnotationPresent(Column.class)){
                String value = field.getAnnotation(Column.class).value();
                columns.add(value);
            }
        }
        return columns;
    }

    public static <O> String getIdCoulmnName(Class<O> inputClass) throws ColumnIdMissmatchException, NoIdFoundException {
        for(Field field : inputClass.getDeclaredFields()){
            if(field.isAnnotationPresent(ID.class)){
                if(field.isAnnotationPresent(Column.class)){
                    return field.getAnnotation(Column.class).value();
                } else {
                    throw new ColumnIdMissmatchException();
                }

            }
        }
        throw new NoIdFoundException();
    }

    public static <O> O getFilledData(ResultSet resultSet, Class<O> inputClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        O object = inputClass.getDeclaredConstructor().newInstance();

        for(Field f : object.getClass().getDeclaredFields()){
            f.setAccessible(true);
            if(f.isAnnotationPresent(Column.class)){
                String type = f.getType().getName();
                String name = f.getAnnotation(Column.class).value();

                if (type.equals(String.class.getName())) {
                    f.set(object, resultSet.getString(name));
                } else if (type.equals(Long.class.getName())) {
                    f.set(object, resultSet.getLong(name));
                } else if (type.equals(Integer.class.getName())) {
                    f.set(object, resultSet.getInt(name));

                }
            }
        }
        return object;
    }
}
