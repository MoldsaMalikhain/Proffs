package moldas.professions.database;

import moldas.professions.PlayerData;

import java.io.*;
import java.sql.*;
import java.util.UUID;

public class PlayerDAO {
    private final DatabaseManager databaseManager;

    public PlayerDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * @param playerUUID    which player stats to update
     * @param playerData    player object with new stats
     * @return              true if everything goes OK, false otherwise
     */
    public Boolean updatePlayerData(UUID playerUUID, PlayerData playerData) {
        byte[] playerDataBytes = objectToBytes(playerData);
        String query = "UPDATE playerdata SET player_object=? WHERE uuid=?";
        try (Connection connection = databaseManager.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, playerUUID.toString());
            pstm.setBytes(2, playerDataBytes);
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param playerUUID    which player stats to save (not update)
     * @param playerData    player object which will be written to the DB
     * @return              true if everything goes OK, false otherwise
     */
    public Boolean setPlayerData(UUID playerUUID, PlayerData playerData) {
        byte[] playerDataBytes = objectToBytes(playerData);
        String query = "INSERT INTO playerdata(uuid, player_object) VALUES(?, ?)";
        try (Connection connection = databaseManager.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, playerUUID.toString());
            pstm.setBytes(2, playerDataBytes);
            pstm.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param playerUUID    id by which player object will be retrieved from the DB
     * @return              player object. Null of something goes wrong
     */
    public PlayerData getPlayerData(UUID playerUUID) {
        String query = String.format("SELECT player_object FROM playerdata WHERE uuid='%s'", playerUUID.toString());
        try (Connection connection = databaseManager.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            PlayerData playerDataObject = bytesToObject(rs.getBytes("player_object"));
            connection.close();
            return playerDataObject;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // converts player object to bytes (or any object)
    private byte[] objectToBytes(PlayerData playerData) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(playerData);
            oos.flush();
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // converts bytes from DB to player object (or any object)
    private PlayerData bytesToObject(byte[] playerDataBytes) {
        try {
            ByteArrayInputStream baip = new ByteArrayInputStream(playerDataBytes);
            ObjectInputStream ois = new ObjectInputStream(baip);
            ois.close();
            return (PlayerData) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
