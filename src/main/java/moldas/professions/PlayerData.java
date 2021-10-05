package moldas.professions;

import moldas.professions.progress.ProfessionProgress;
import moldas.professions.progress.data.ProgressMaxValues;
import moldas.professions.stats.StatsData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.Serializable;
import java.util.HashMap;

public class PlayerData implements Serializable {

    public String playerName;
    public HashMap <String, String> playerProfession = new HashMap<>();
    public ProfessionProgress playerProfessionProgress = new ProfessionProgress();
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

    /**
     * @param amount will be added to primary profession progress if it exist
     * @return true if added
     * false if player already get max lvl of that profession
     */
    public boolean addPrimaryProgress(int amount) {
        if(!playerProfessionProgress.primaryMaxLvl() && playerProfession.get("Primary") != null) {
            playerProfessionProgress.primaryProfProgress += amount;
            if((playerProfessionProgress.primaryProfLvl * ProgressMaxValues.POINTS_TO_LVL_UP)
                    <= playerProfessionProgress.primaryProfProgress) {
                playerProfessionProgress.primaryProfProgress -=
                        playerProfessionProgress.primaryProfLvl * ProgressMaxValues.POINTS_TO_LVL_UP;
                playerProfessionProgress.primaryProfLvl += 1;
                Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(*)" +
                        ChatColor.GOLD + " You get a new lvl of " + playerProfession.get("Primary") + " profession! " +
                        "Now its " + playerProfessionProgress.primaryProfLvl + "!");
            }
            return true;
        }
        return false;
    }

    /**
     * @param amount will be added to secondary profession progress if it exist
     * @return true if added
     * false if player already get max lvl of that profession
     */
    public boolean addSecondaryProgress(int amount) {
        if(!playerProfessionProgress.secondaryMaxLvl() && playerProfession.get("Secondary") != null) {
            playerProfessionProgress.secondaryProfProgress += amount;
            if((playerProfessionProgress.secondaryProfLvl * ProgressMaxValues.POINTS_TO_LVL_UP)
                    <= playerProfessionProgress.secondaryProfProgress) {
                playerProfessionProgress.secondaryProfProgress -=
                        playerProfessionProgress.secondaryProfLvl * ProgressMaxValues.POINTS_TO_LVL_UP;
                playerProfessionProgress.secondaryProfLvl += 1;
                Bukkit.getPlayer(playerName).sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(*)" +
                        ChatColor.GOLD + " You get a new lvl of " + playerProfession.get("Secondary") + " profession! " +
                        "Now its " + playerProfessionProgress.secondaryProfLvl + "!");
            }
            return true;
        }

        return false;
    }

    //TODO: Logic for lvlup stats of player
}
