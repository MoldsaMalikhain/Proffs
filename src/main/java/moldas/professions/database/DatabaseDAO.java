package moldas.professions.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static moldas.professions.Professions.DATABASE_URL;

public class DatabaseDAO {
    private static Connection connection;

    public Boolean createDatabase() {
        try {
            return DriverManager.getConnection(DATABASE_URL) != null;
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

    public Boolean createPlayerDataTable() {
        connection = this.getConnection();
        String query = "CREATE TABLE IF NOT EXISTS playerdata(" +
                "uuid TEXT PRIMARY KEY," +
                "player_name TEXT," +
                "primary_lvl INTEGER," +
                "primary_prof TEXT," +
                "secondary_lvl INTEGER," +
                "secondary_prof TEXT," +
                "speed REAL," +
                "harvest_speed REAL," +
                "health INTEGER," +
                "jump_height REAL," +
                "falling_damage REAL," +
                "damage REAL," +
                "armor REAL," +
                "shift_speed REAL," +
                "athletic INTEGER," +
                "acrobatic INTEGER," +
                "strength INTEGER," +
                "blocking INTEGER," +
                "vitality INTEGER," +
                "stealth INTEGER)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
