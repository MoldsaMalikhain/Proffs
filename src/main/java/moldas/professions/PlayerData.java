package moldas.professions;

import moldas.professions.prof.Profession;
import moldas.professions.progress.data.ProgressMaxValues;
import moldas.professions.stats.StatsData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.Serializable;
import java.util.HashMap;

public class PlayerData implements Serializable {

    public String playerName;
    public HashMap <String, Profession> playerProfession = new HashMap<>();
    public StatsData playerStats = new StatsData();

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

        Profession profession = new Profession(professionName);
        playerProfession.put(professionType, profession);

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
                    ChatColor.GOLD + " You leave " + playerProfession.get(professionType).name + " profession!");
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

    /**
     * @param amount will be added to primary profession progress if it exist
     * @return true if added
     * false if player already get max lvl of that profession
     */
    public boolean addProgress(String professionType, int amount) {
        Profession profession = playerProfession.get(professionType);

        if (!profession.isMaxLvl()) {
            profession.progress += amount;
            if ((profession.lvl * ProgressMaxValues.POINTS_TO_LVL_UP) <= profession.progress) {
                profession.progress -= profession.lvl * ProgressMaxValues.POINTS_TO_LVL_UP;
                profession.lvl += 1;
                Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.GOLD + " You got new level of " + profession.name + " profession!");
            }
            return true;
        }
        return false;
    }
}
