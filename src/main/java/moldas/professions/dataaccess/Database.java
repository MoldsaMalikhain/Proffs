package moldas.professions.dataaccess;

import moldas.professions.PlayerData;

import java.util.UUID;

public interface Database {
    PlayerData getPlayerObject(UUID playerUUID);
    Object getField(String statName, UUID uuid);
    Object setField(String statName, UUID uuid);
}
