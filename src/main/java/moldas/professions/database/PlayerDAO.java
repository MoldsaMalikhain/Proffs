package moldas.professions.database;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerDAO {
    final DatabaseDAO databaseDAO;

    public PlayerDAO(DatabaseDAO databaseDAO) {
        this.databaseDAO = databaseDAO;
    }

    public Boolean setPlayerData(PlayerDataHandler playerHandler, UUID playerUUID) {
        Connection connection = databaseDAO.getConnection();
        String query = "INSERT INTO playerdata(uuid," +
                "player_name," +
                "primary_lvl," +
                "primary_prof," +
                "secondary_lvl," +
                "secondary_prof," +
                "speed," +
                "harvest_speed," +
                "health," +
                "jump_height," +
                "falling_damage," +
                "damage," +
                "armor," +
                "shift_speed," +
                "athletic," +
                "acrobatic," +
                "strength," +
                "blocking," +
                "vitality," +
                "stealth) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(playerUUID));
            preparedStatement.setString(2, playerHandler.getPlayer(playerUUID).playerName);
            preparedStatement.setInt(3, playerHandler.getPlayer(playerUUID).primaryProfLvl);
            preparedStatement.setString(4, playerHandler.getPlayer(playerUUID).playerProfession.get("Primary"));
            preparedStatement.setInt(5, playerHandler.getPlayer(playerUUID).secondaryProfLvl);
            preparedStatement.setString(6, playerHandler.getPlayer(playerUUID).playerProfession.get("Secondary"));
            preparedStatement.setFloat(7, playerHandler.getPlayer(playerUUID).speed);
            preparedStatement.setFloat(8, playerHandler.getPlayer(playerUUID).harvestSpeedMultiplier);
            preparedStatement.setFloat(9, playerHandler.getPlayer(playerUUID).health);
            preparedStatement.setFloat(10, playerHandler.getPlayer(playerUUID).jumpHeightMultiplier);
            preparedStatement.setFloat(11, playerHandler.getPlayer(playerUUID).fallingDamageMultiplier);
            preparedStatement.setFloat(12, playerHandler.getPlayer(playerUUID).damageMultiplier);
            preparedStatement.setFloat(13, playerHandler.getPlayer(playerUUID).armorMultiplier);
            preparedStatement.setFloat(14, playerHandler.getPlayer(playerUUID).shiftSpeedMultiplier);
            preparedStatement.setInt(15, playerHandler.getPlayer(playerUUID).playerStats.athletic);
            preparedStatement.setInt(16, playerHandler.getPlayer(playerUUID).playerStats.acrobatic);
            preparedStatement.setInt(17, playerHandler.getPlayer(playerUUID).playerStats.strength);
            preparedStatement.setInt(18, playerHandler.getPlayer(playerUUID).playerStats.blocking);
            preparedStatement.setInt(19, playerHandler.getPlayer(playerUUID).playerStats.vitality);
            preparedStatement.setInt(20, playerHandler.getPlayer(playerUUID).playerStats.stealth);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePlayerData(PlayerDataHandler playerHandler, UUID playerUUID) {
        return true;
    }

    public boolean exists(UUID playerUUID) {
        return true;
    }

    public PlayerData getPlayerData(UUID playerUUID) {
        return null;
    }
}
