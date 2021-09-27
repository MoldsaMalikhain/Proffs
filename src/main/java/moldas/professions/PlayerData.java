package moldas.professions;

import moldas.professions.stats.StatsData;

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

        if(playerProfession.containsKey("Primary")) { return false; }
        if(playerProfession.containsKey("Secondary")) { return false; }

        playerProfession.put(professionType, professionName);

        return true;
    }
}
