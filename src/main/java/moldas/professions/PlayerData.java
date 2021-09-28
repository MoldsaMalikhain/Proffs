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
     * @param professionType
     * @param professionName
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
}
