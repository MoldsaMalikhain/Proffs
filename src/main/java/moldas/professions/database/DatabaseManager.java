package moldas.professions.database;

import moldas.professions.database.interfaces.DatabaseManagerInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static moldas.professions.Professions.DATABASE_URL;

public class DatabaseManager implements DatabaseManagerInterface {
    private static Connection connection;

    /**
     * Creates a database file
     * @return  true if database has been created, false otherwise
     */
    @Override
    public Boolean createDatabase() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            if (connection != null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @return  Connection to the database
     */
    @Override
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create database table in format(uuid (uuid) / player_object (blob))
     * @return  true if table has been created, false otherwise
     */
    @Override
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
