package moldas.professions;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDataHandler {
    private HashMap <UUID, PlayerData> players = new HashMap<>();

    //Return Hashmap of all Players
    public HashMap <UUID, PlayerData> getAllPlayers() { return players; }

    //Return Player by its UUID
    public PlayerData getPlayer(UUID playerUUID) { return players.get(playerUUID); }

    //Add new unique Player to Hashmap, if player added return 'true'
    public boolean addPlayer(UUID playerUUID, String playerName) {
        if(!players.containsKey(playerUUID)) {
            PlayerData newPlayer = new PlayerData(playerName);

            players.put(playerUUID, newPlayer);
            return true;
        }

        return false;
    }

    public void playerUpdate(UUID playerUUID, PlayerData playerData) {
        players.replace(playerUUID, playerData);
    }
}
