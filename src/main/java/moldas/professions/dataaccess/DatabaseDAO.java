package moldas.professions.dataaccess;

import moldas.professions.PlayerData;

import java.sql.Connection;
import java.util.UUID;

public class DatabaseDAO implements Database {
    private static Connection connection;

    @Override
    public PlayerData getPlayerObject(UUID playerUUID) {
        return null;
    }

    @Override
    public Object getField(String statName, UUID uuid) {
        return null;
    }

    @Override
    public Object setField(String statName, UUID uuid) {
        return null;
    }

    private Connection getConnection() {
        return null;
    }

    private Connection connectToDatabase() {
        return null;
    }
}
