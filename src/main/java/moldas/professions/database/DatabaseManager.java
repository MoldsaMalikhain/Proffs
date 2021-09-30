package moldas.professions.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static moldas.professions.Professions.DATABASE_URL;

public class DatabaseManager {
    private static Connection connection;

    public Boolean createDatabase() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            if (connection != null) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(DATABASE_URL);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean createPlayerdataTable() {
        connection = this.getConnection();
        String query = "CREATE TABLE IF NOT EXISTS playerdata(" +
                "uuid UUID PRIMARY KEY," +
                "player_object BLOB)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
