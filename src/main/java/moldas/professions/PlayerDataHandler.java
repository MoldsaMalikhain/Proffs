package moldas.professions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDataHandler {

    private HashMap <UUID, PlayerData> players = new HashMap<>();
    /**
     * @return Hashmap of all Players
     */
    public HashMap <UUID, PlayerData> getAllPlayers() { return players; }

    /**
     * @param playerUUID
     * @return Player from hashmap by its UUID
     */
    public PlayerData getPlayer(UUID playerUUID) { return players.get(playerUUID); }

    /**
     * @param playerUUID
     * @return true if player exist in hashmap
     */
    public boolean playerExist(UUID playerUUID) { return players.containsKey(playerUUID); }

    /**
     * Add new unique Player to Hashmap, if player added return 'true'
     * @param playerUUID
     * @param playerName
     * @return true if player added
     */
    public boolean addPlayer(UUID playerUUID, String playerName) {
        if(!players.containsKey(playerUUID)) {
            PlayerData newPlayer = new PlayerData(playerName);

            players.put(playerUUID, newPlayer);
            playerUpdate(playerUUID, newPlayer);
            return true;
        }

        return false;
    }

    /**
     * Deleting player from hashmap of all players
     * @param playerUUID
     * @return true if player was deleted
     * false if player do not exist in hashmap
     */
    public boolean deletePlayer(UUID playerUUID) {
        if(!players.containsKey(playerUUID)) {
            players.remove(playerUUID);

            return true;
        }

        return false;
    }

    /**
     * Update player stats
     * @param playerUUID
     * @param playerData
     */
    public void playerUpdate(UUID playerUUID, PlayerData playerData) {
        //TODO All stats needed to be updated here whenever player gets upgraded his stats

        //TODO Save info to bd
        players.replace(playerUUID, playerData);
        Player player = Bukkit.getPlayer(playerData.playerName);

        player.setHealth(20);
        player.setHealthScale(playerData.health);
        player.setWalkSpeed(playerData.speed);
    }
}
