package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigManager {

    private static Properties prop = new Properties();

    static {
        try {
            prop.load(new FileInputStream("src/test/resources/config.properties"));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String getProperty(String key){
        return prop.getProperty(key);
    }

    //URls
    public static String getLandingPageURL(){
        return getProperty("parasoft.landingpage");
    }
    public static String getAdminPageURL(){
        return getProperty("parasoft.adminpage");
    }
    public static String getRegisterPageURL(){
        return getProperty("parasoft.registerpage");
    }

    //API URls
    public static String wordsURI() { return getProperty("words.base");}

    //API Headers
    public static String apiKey() { return getProperty("x-rapidapi-key");}

}
