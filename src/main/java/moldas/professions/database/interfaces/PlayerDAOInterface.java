package moldas.professions.database.interfaces;

import moldas.professions.PlayerData;
import moldas.professions.exceptions.SetPlayerException;

import java.util.UUID;

public interface PlayerDAOInterface {
    Boolean exists(UUID playerUUID);
    Boolean updatePlayerData(UUID playerUUID, PlayerData playerData);
    Boolean setPlayerData(UUID playerUUID, PlayerData playerData) throws SetPlayerException;
    PlayerData getPlayerData(UUID playerUUID);
}
