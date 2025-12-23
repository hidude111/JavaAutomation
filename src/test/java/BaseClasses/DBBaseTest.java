package BaseClasses;


import config.ConfigManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.sql.*;

public class DBBaseTest {
    protected Connection connection;
    //dont want to use Statement because it risks sql injections. Use PreparedStatement nstead
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    private String dbHost = ConfigManager.getDBHost();
    private String dbUser = ConfigManager.getDBUser();
    private String dbPW = ConfigManager.getDBPW();
    private String dbJDBC = ConfigManager.getJDBC();

    //use try-with-resources
    @BeforeClass
    public void setup() throws SQLException, ClassNotFoundException {
        Class.forName(dbJDBC);
        DriverManager.registerDriver(new org.postgresql.Driver());
        connection = DriverManager.getConnection(dbHost,dbUser,dbPW);
    }

    @AfterClass
    public void tearDown() throws SQLException, ClassNotFoundException {
        resultSet.close();
        connection.close();
        statement.close();

    }
}
