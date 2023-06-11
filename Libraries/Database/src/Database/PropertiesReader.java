package Database;

import Database.Exceptions.NullInputStreamException;
import Database.Exceptions.NullPropertyFieldException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public static final String DRIVER = "DRIVER";
    public static final String URL = "URL";
    public static final String USER = "USER";
    public static final String PASS = "PASS";

    protected String driver;
    protected String url;
    protected String user;
    protected String pass;


    public PropertiesReader() throws NullInputStreamException, NullPropertyFieldException, IOException {
        String filename = "data.properties";
        Properties properties = new Properties();
        InputStream inputStream;


        inputStream = getClass().getResourceAsStream(filename);
        if(inputStream == null) {
            throw new NullInputStreamException();
        }


        properties.load(inputStream);
        driver = properties.getProperty(DRIVER);
        if(driver == null || driver.equals("")){
            throw new NullPropertyFieldException();
        }
        url = properties.getProperty(URL);
        if(url == null || url.equals("")){
            throw new NullPropertyFieldException();
        }
        user = properties.getProperty(USER);
        if(user == null || user.equals("")){
            throw new NullPropertyFieldException();
        }
        pass = properties.getProperty(PASS);
        if(pass == null || pass.equals("")){
            throw new NullPropertyFieldException();
        }
    }

    @Override
    public String toString() {
        return "PropertiesReader{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
