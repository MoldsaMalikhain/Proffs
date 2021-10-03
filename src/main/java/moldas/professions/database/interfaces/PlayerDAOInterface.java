package moldas.professions.database.interfaces;

import moldas.professions.PlayerData;

import java.util.UUID;

public interface PlayerDAOInterface {
    Boolean exists(UUID playerUUID);
    Boolean updatePlayerData(UUID playerUUID, PlayerData playerData);
    Boolean setPlayerData(UUID playerUUID, PlayerData playerData);
    PlayerData getPlayerData(UUID playerUUID);
}
