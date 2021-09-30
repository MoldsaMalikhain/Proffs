package moldas.professions;

import moldas.professions.stats.StatsData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashMap;

public class PlayerData {

    public String playerName;
    public HashMap <String, String> playerProfession = new HashMap<>();
    public StatsData playerStats = new StatsData();
    public int primaryProfLvl = 0;
    public int secondaryProfLvl = 0;
    public float speed = (float) 0.2;
    public float harvestSpeedMultiplier = 1;
    public float health = 20;
    public float jumpHeightMultiplier = 1;
    public float fallingDamageMultiplier = 1;
    public float damageMultiplier = 1;
    public float armorMultiplier = 1;
    public float shiftSpeedMultiplier = 1;

    PlayerData(String _playerName) {
        playerName = _playerName;
    }

    /**
     * Set profession for player
     * @param professionType profession type
     * @param professionName profession name
     * @return true if profession added
     * false if player already have profession of that type
     */
    public boolean setProfession(String professionType, String professionName) {

        if(playerProfession.containsKey(professionType)) {
            Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                    ChatColor.RESET + " You already have " + professionType + " profession!");
            return false;
        }

        Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(*)" +
                ChatColor.GOLD + " Congratulation, you now have " + professionName + " profession!");
        playerProfession.put(professionType, professionName);

        return true;
    }

    /**
     * Delete profession of entered type
     * @param professionType profession type
     * @return true if profession deleted
     * false if profession of that type is not set to player
     */
    public boolean deleteProfession(String professionType) {

        if(playerProfession.containsKey(professionType)) {
            Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(*)" +
                    ChatColor.GOLD + " You leave " + playerProfession.get(professionType) + " profession!");
            playerProfession.remove(professionType);

            return true;
        }

        Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(*)" +
                ChatColor.GOLD + " You don`t have that profession!");

        return false;
    }

    /**
     * @param professionType profession type
     * @return true if player have that type of profession
     * false if profession of that type is not set to player
     */
    public boolean professionExist(String professionType) {
        if(playerProfession.containsKey(professionType)) return true;
        else return false;
    }
}
