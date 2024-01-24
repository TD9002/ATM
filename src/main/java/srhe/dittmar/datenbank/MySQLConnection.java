package srhe.dittmar.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLConnection {

    private String host, username, dbName, password;
    private int port;
    private Connection connection = null;

    public MySQLConnection(Properties properties) {
        if (properties != null){
            host = properties.getProperty("host");
            username = properties.getProperty("username");
            dbName = properties.getProperty("dbName");
            password =properties.getProperty("password");
            port = Integer.valueOf(properties.getProperty("port"));
        }
    }

    public Connection getConnection() {
        if (this.connection == null) {
            String url = "jdbc:mysql://" + host + ":" + port + "/";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Error: Cannot connect to the database. " + ex.getMessage());
            }
        }
        return connection;
    }
}
